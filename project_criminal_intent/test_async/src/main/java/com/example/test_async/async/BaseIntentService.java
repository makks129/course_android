package com.example.test_async.async;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public abstract class BaseIntentService extends IntentService {

    private static final String TAG = "TAG_" + BaseIntentService.class.getSimpleName();

    public BaseIntentService(String name) {
        super(name);
        Log.d(TAG, "Constructor");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "onHandleIntent: intent = " + intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.d(TAG, "onStart: intent = " + intent + ", flags = " + flags + ", startId = " + startId);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
