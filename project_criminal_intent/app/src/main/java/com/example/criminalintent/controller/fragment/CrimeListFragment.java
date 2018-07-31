package com.example.criminalintent.controller.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.criminalintent.R;
import com.example.criminalintent.controller.adapter.CrimeListAdapter;
import com.example.criminalintent.controller.activity.CrimeActivity;
import com.example.criminalintent.controller.activity.CrimePagerActivity;
import com.example.criminalintent.controller.fragment.base.BaseFragment;
import com.example.criminalintent.model.Crime;
import com.example.criminalintent.model.CrimeLab;

import java.util.List;

// TODO add divider line between list items
public class CrimeListFragment extends BaseFragment {

    private CrimeListAdapter adapter;


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

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}