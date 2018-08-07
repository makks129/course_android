package com.example.test_async.async_task;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test_async.R;
import com.example.test_async.async.AsyncUtils;
import com.example.test_async.async.BaseAsyncTask;
import com.example.test_async.base.BaseFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestAsyncTaskFragment extends BaseFragment {

    private TextView text;
    private BaseAsyncTask<String, Integer, Void> asyncTask;

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
        if (asyncTask != null) {
            return;
        }
        asyncTask = new BaseAsyncTask<String, Integer, Void>() {
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
                    AsyncUtils.sleep(50);
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
                asyncTask = null;
            }
        };

        asyncTask.execute("a", "b", "c");

    }

//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        if (asyncTask != null) {
//            asyncTask.cancel(false);
//        }
//    }
}
