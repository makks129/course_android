package com.example.test_async;

import android.content.Intent;
import android.support.v4.app.Fragment;

public class TestIntentServiceActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment(Intent intent) {
        return new TestIntentServiceFragment();
    }
}
