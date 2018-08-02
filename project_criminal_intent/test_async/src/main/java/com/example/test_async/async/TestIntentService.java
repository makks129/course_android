package com.example.test_async.async;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;

public class TestIntentService extends BaseIntentService {

    public static final String ACTION_PROGRESS = "com.example.test_async.async.TestIntentService.ACTION_PROGRESS";
    public static final String ACTION_FINISH = "com.example.test_async.async.TestIntentService.ACTION_FINISH";

    public static final String EXTRA_PROGRESS = "EXTRA_PROGRESS";


    public TestIntentService() {
        super(TestIntentService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        super.onHandleIntent(intent);

        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);

        for (int i = 0; i < 100; i++) {

            Intent progressIntent = new Intent(ACTION_PROGRESS);
            progressIntent.putExtra(EXTRA_PROGRESS, i);
            localBroadcastManager.sendBroadcast(progressIntent);

            AsyncUtils.sleep(100);
        }

        Intent finishIntent = new Intent(ACTION_FINISH);
        localBroadcastManager.sendBroadcast(finishIntent);
    }

}
