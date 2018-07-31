package com.example.criminalintent.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

public class MyTextWatcher implements TextWatcher {

    private static final String TAG_TEXT_WATCHER = "TAG_TEXT_WATCHER";

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        Log.d(TAG_TEXT_WATCHER, "beforeTextChanged: charSequence = " + charSequence.toString() + ", ints = " + i + ", " + i1 + ", " + i2);
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        Log.d(TAG_TEXT_WATCHER, "onTextChanged: charSequence = " + charSequence.toString() + ", ints = " + i + ", " + i1 + ", " + i2);
    }

    @Override
    public void afterTextChanged(Editable editable) {
        Log.d(TAG_TEXT_WATCHER, "afterTextChanged: editable = " + editable.toString());
    }
}
