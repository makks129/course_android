package com.example.test_async.intent_service;

import android.content.Intent;
import android.support.v4.app.Fragment;

import com.example.test_async.base.SingleFragmentActivity;

public class TestIntentServiceActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment(Intent intent) {
        return new TestIntentServiceFragment();
    }
}
