package com.example.criminalintent.controller.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.criminalintent.controller.fragment.CrimeFragment;
import com.example.criminalintent.model.Crime;

import java.util.ArrayList;
import java.util.List;

public class CrimePagerAdapter extends FragmentStatePagerAdapter {

    private List<Crime> items;

    public CrimePagerAdapter(FragmentManager fm) {
        super(fm);
        items = new ArrayList<>();
    }

    public void setItems(List<Crime> items) {
        this.items = items;
    }

    @Override
    public Fragment getItem(int i) {
        Crime item = items.get(i);
        return CrimeFragment.newInstance(item.getId());
    }

    @Override
    public int getCount() {
        return items.size();
    }

}
