package com.example.test_async;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.test_async.async.AsyncUtils;
import com.example.test_async.async.BaseAsyncTask;

public class TestAsyncTaskFragment extends BaseFragment {

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

        runAsyncTask();

        return view;
    }


    private void runAsyncTask() {
        new BaseAsyncTask<String, Integer, Void>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                text.setText("Start! ");
            }

            @Override
            protected Void doInBackground(String... strings) {
                super.doInBackground(strings);

                for (int i = 0; i < 100; i++) {
                    publishProgress(i);
                    AsyncUtils.sleep(100);
                }

                return null;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                text.append(values[0] + " ");
            }

            @Override
            protected void onPostExecute(Void v) {
                super.onPostExecute(v);
                text.append("Finish!");
            }
        };
    }


}
