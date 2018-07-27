package com.example.criminalintent.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.example.criminalintent.R;

public class CrimeActivity extends SingleFragmentActivity {

    private static final String TAG = "TAGTAG_A";


    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
