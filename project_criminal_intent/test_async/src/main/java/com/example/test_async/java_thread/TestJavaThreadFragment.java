package com.example.test_async.java_thread;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.test_async.R;
import com.example.test_async.async.AsyncUtils;
import com.example.test_async.base.BaseFragment;

public class TestJavaThreadFragment extends BaseFragment {

    private TextView text;


    @Override
    public void onCreate(@Nullable Bundle state) {
        super.onCreate(state);
//        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        super.onCreateView(inflater, container, state);
        View view = inflater.inflate(R.layout.fragment_test, container, false);

        text = view.findViewById(R.id.text);

        runThreadTask();

        return view;
    }


    private void runThreadTask() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                if (getActivity() != null) {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            text.setText("Start! ");
                        }
                    });
                }

                for (int i = 0; i < 100; i++) {
                    final int finalI = i;
                    if (getActivity() != null) {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                text.append(finalI + " ");
                            }
                        });
                    }
                    AsyncUtils.sleep(50);
                }


                if (getActivity() != null) {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            text.append("Finish!");
                        }
                    });
                }

            }
        }).start();
    }

}
