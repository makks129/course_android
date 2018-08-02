package com.example.test_async;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.test_async.async.TestIntentService;

public class TestIntentServiceFragment extends BaseFragment {

    private TextView text;

    private BroadcastReceiver receiver;


    @Override
    public void onCreate(@Nullable Bundle state) {
        super.onCreate(state);
//        setRetainInstance(true);

        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent == null || intent.getAction() == null) {
                    return;
                }
                if (intent.getAction().equals(TestIntentService.ACTION_PROGRESS)) {
                    int progress = intent.getIntExtra(TestIntentService.EXTRA_PROGRESS, -1);
                    text.append(progress + " ");
                }
                if (intent.getAction().equals(TestIntentService.ACTION_FINISH)) {
                    text.append("Finish!");
                }
            }
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        super.onCreateView(inflater, container, state);
        View view = inflater.inflate(R.layout.fragment_test, container, false);

        text = view.findViewById(R.id.text);

        runIntentServiceTask();

        return view;
    }

    private void runIntentServiceTask() {
        text.setText("Start! ");
        Intent service = new Intent(getActivity(), TestIntentService.class);
        getActivity().startService(service);
    }

    @Override
    public void onResume() {
        super.onResume();
        registerReceiver();
    }

    @Override
    public void onPause() {
        super.onPause();
        unregisterReceiver();
    }

    private void registerReceiver() {
        LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(getActivity());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TestIntentService.ACTION_PROGRESS);
        intentFilter.addAction(TestIntentService.ACTION_FINISH);
        lbm.registerReceiver(receiver, intentFilter);
    }

    private void unregisterReceiver() {
        LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(getActivity());
        lbm.unregisterReceiver(receiver);
    }
}
