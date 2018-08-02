package com.example.criminalintent.controller.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.criminalintent.R;
import com.example.criminalintent.controller.adapter.CrimeListAdapter;
import com.example.criminalintent.controller.activity.CrimeActivity;
import com.example.criminalintent.controller.activity.CrimePagerActivity;
import com.example.criminalintent.controller.fragment.base.BaseFragment;
import com.example.criminalintent.model.Crime;
import com.example.criminalintent.model.CrimeLab;
import com.example.criminalintent.model.prefs.Prefs;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// TODO add divider line between list items
public class CrimeListFragment extends BaseFragment {

    private CrimeListAdapter adapter;


    @Override
    public void onCreate(@Nullable Bundle state) {
        super.onCreate(state);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);

        RecyclerView rv = view.findViewById(R.id.list);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new CrimeListAdapter();
        adapter.setListener(new CrimeListAdapter.Listener() {
            @Override
            public void onClick(Crime item) {
                CrimeActivity.start(getActivity(), item.getUuid());
            }

            @Override
            public void onLongClick(Crime item) {
                CrimePagerActivity.start(getActivity(), item.getUuid());
            }
        });
        List<Crime> crimes = CrimeLab.getInstance().getCrimes();
        adapter.setItems(crimes);
        rv.setAdapter(adapter);

        scrollToLastSeenCrime(rv);

        return view;
    }

    private void scrollToLastSeenCrime(RecyclerView rv) {
        String id = Prefs.getString(CrimeFragment.PREFS_LAST_CRIME_ID);
        if (id != null) {
            int index = CrimeLab.getInstance().getCrimeIndex(UUID.fromString(id));
            rv.scrollToPosition(index);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.crime_list, menu);
    }

    // TODO create new crime in CrimeActivity, when you press save
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.newCrime:
                Crime crime = new Crime();
                CrimeLab.getInstance().addCrime(crime);
                CrimeActivity.start(getActivity(), crime.getUuid());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
