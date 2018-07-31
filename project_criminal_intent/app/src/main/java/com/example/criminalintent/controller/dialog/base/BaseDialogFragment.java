package com.example.criminalintent.controller.dialog.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.criminalintent.controller.fragment.base.BaseFragment;

public abstract class BaseDialogFragment extends DialogFragment{

    private static final String TAG = "TAG_" + BaseDialogFragment.class.getSimpleName();

    public BaseDialogFragment() {
        Log.d(TAG, "Constructor");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        Log.d(TAG, "onAttachFragment: childFragment = " + childFragment.toString());
    }

    @Override
    public void onCreate(@Nullable Bundle state) {
        super.onCreate(state);
        Log.d(TAG, "onCreate: state = " + (state != null ? state.toString() : state));
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle state) {
        Log.d(TAG, "onCreateDialog: state = " + (state != null ? state.toString() : state));
        return super.onCreateDialog(state);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        Log.d(TAG, "onCreateView: state = " + (state != null ? state.toString() : state));
        return super.onCreateView(inflater, container, state);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle state) {
        super.onSaveInstanceState(state);
        Log.d(TAG, "onSaveInstanceState: state = " + (state != null ? state.toString() : state));
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach");
    }

}
