package com.example.test_async.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.test_async.R;

public abstract class SingleFragmentActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
        if (fragment == null) {
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, createFragment(getIntent()))
                    .commit();
        }

    }

    protected abstract Fragment createFragment(Intent intent);

}
