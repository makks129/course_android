package com.example.test_async.java_thread;

import android.content.Intent;
import android.support.v4.app.Fragment;

import com.example.test_async.base.SingleFragmentActivity;

public class TestJavaThreadActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment(Intent intent) {
        return new TestJavaThreadFragment();
    }
}
