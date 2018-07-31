package com.example.criminalintent.controller.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.example.criminalintent.controller.fragment.CrimeFragment;
import com.example.criminalintent.controller.activity.base.SingleFragmentActivity;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {

    private static final String EXTRA_CRIME_ID = "EXTRA_CRIME_ID";

    @Override
    protected Fragment createFragment(Intent intent) {
        UUID crimeId = (UUID) intent.getSerializableExtra(EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(crimeId);
    }

    public static void start(Context context, UUID crimeId) {
        Intent intent = new Intent(context, CrimeActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);
        context.startActivity(intent);
    }

}
