package com.example.test_async.async;

import android.os.AsyncTask;
import android.util.Log;

import java.util.Arrays;

public abstract class BaseAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {

    private static final String TAG = "TAG_" + BaseAsyncTask.class.getSimpleName();

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(TAG, "onPreExecute");
    }

    @Override
    protected Result doInBackground(Params... params) {
        Log.d(TAG, "doInBackground: params = " + (params != null ? Arrays.toString(params) : null));
        return null;
    }

    @Override
    protected void onProgressUpdate(Progress... values) {
        Log.d(TAG, "onProgressUpdate: values = " + (values != null ? Arrays.toString(values) : null));
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled() {
        Log.d(TAG, "onCancelled");
        super.onCancelled();
    }

    @Override
    protected void onCancelled(Result result) {
        Log.d(TAG, "onCancelled: result = " + (result != null ? result.toString() : null));
        super.onCancelled(result);
    }

    @Override
    protected void onPostExecute(Result result) {
        Log.d(TAG, "onPostExecute: result = " + (result != null ? result.toString() : null));
        super.onPostExecute(result);
    }
}
