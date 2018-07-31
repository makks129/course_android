package com.example.criminalintent.controller.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.example.criminalintent.R;
import com.example.criminalintent.controller.activity.CrimeActivity;
import com.example.criminalintent.controller.dialog.DatePickerDialogFragment;
import com.example.criminalintent.controller.fragment.base.BaseFragment;
import com.example.criminalintent.model.Crime;
import com.example.criminalintent.model.CrimeLab;
import com.example.criminalintent.view.MyTextWatcher;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

public class CrimeFragment extends BaseFragment {

    private static final String EXTRA_CRIME_ID = "EXTRA_CRIME_ID";
    private static final String DATE_PICKED_DIALOG_TAG = "DATE_PICKED_DIALOG_TAG";

    private final DateFormat dateFormat = SimpleDateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);

    private Crime crime;

    private TextView date;


    public static CrimeFragment newInstance(UUID crimeId) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_CRIME_ID, crimeId);
        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle state) {
        super.onCreate(state);
        UUID crimeId = (UUID) getArguments().getSerializable(EXTRA_CRIME_ID);
        crime = CrimeLab.getInstance().getCrime(crimeId);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime, container, false);

        final EditText inputTitle = view.findViewById(R.id.inputTitle);
        inputTitle.setText(crime.getTitle());
        // TODO put caret after the text
        inputTitle.addTextChangedListener(new MyTextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                super.onTextChanged(charSequence, i, i1, i2);
                crime.setTitle(charSequence.toString());
            }
        });

        date = view.findViewById(R.id.date);
        updateDate();
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialogFragment dialog = DatePickerDialogFragment.getInstance(crime.getCalendar());
                dialog.show(getChildFragmentManager(), DATE_PICKED_DIALOG_TAG);
            }
        });

        CheckBox checkBoxSolved = view.findViewById(R.id.checkBoxSolved);
        checkBoxSolved.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                crime.setSolved(checked);
            }
        });
        checkBoxSolved.setChecked(crime.isSolved());

        return view;
    }

    private void updateDate() {
        String dateTime = dateFormat.format(crime.getCalendar().getTime());
        date.setText(dateTime);
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        if (childFragment instanceof DatePickerDialogFragment) {
            DatePickerDialogFragment datePickerDialogFragment = (DatePickerDialogFragment) childFragment;
            datePickerDialogFragment.setListener(new DatePickerDialogFragment.Listener() {
                @Override
                public void onNewDateChosen(Calendar newCalendar) {
                    crime.setCalendar(newCalendar);
                    updateDate();
                }
            });
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.crime_list, menu);
    }

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
