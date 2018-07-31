package com.example.criminalintent.controller.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import com.example.criminalintent.R;
import com.example.criminalintent.controller.adapter.CrimePagerAdapter;
import com.example.criminalintent.controller.activity.base.BaseActivity;
import com.example.criminalintent.model.CrimeLab;

import java.util.UUID;

// TODO add buttons to jump to first and last crime
public class CrimePagerActivity extends BaseActivity {

    private static final String EXTRA_CRIME_ID = "EXTRA_CRIME_ID";

    private CrimePagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_crime_pager);

        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);

        ViewPager viewPager = findViewById(R.id.viewPager);
        adapter = new CrimePagerAdapter(getSupportFragmentManager());
        adapter.setItems(CrimeLab.getInstance().getCrimes());
        viewPager.setAdapter(adapter);

        int crimeIndex = CrimeLab.getInstance().getCrimeIndex(crimeId);
        viewPager.setCurrentItem(crimeIndex);

    }

    public static void start(Context context, UUID crimeId) {
        Intent intent = new Intent(context, CrimePagerActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);
        context.startActivity(intent);
    }

}
