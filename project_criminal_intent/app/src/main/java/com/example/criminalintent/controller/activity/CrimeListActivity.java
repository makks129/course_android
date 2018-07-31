package com.example.criminalintent.controller.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;

import com.example.criminalintent.controller.fragment.CrimeListFragment;
import com.example.criminalintent.controller.activity.base.SingleFragmentActivity;

// TODO implement two-pane master-detail interface (see book, page 317)
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(Intent intent) {
        return new CrimeListFragment();
    }

}
