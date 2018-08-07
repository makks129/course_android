package com.example.test_async.async_task;

import android.content.Intent;
import android.support.v4.app.Fragment;

import com.example.test_async.base.SingleFragmentActivity;

public class TestAsyncTaskActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment(Intent intent) {
        return new TestAsyncTaskFragment();
    }
}
