package com.example.test_async;

import android.content.Intent;
import android.support.v4.app.Fragment;

public class TestAsyncTaskActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment(Intent intent) {
        return new TestAsyncTaskFragment();
    }
}
