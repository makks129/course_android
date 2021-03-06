package com.example.criminalintent.controller.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.example.criminalintent.R;
import com.example.criminalintent.controller.dialog.DatePickerDialogFragment;
import com.example.criminalintent.controller.fragment.base.BaseFragment;
import com.example.criminalintent.model.Crime;
import com.example.criminalintent.model.CrimeLab;
import com.example.criminalintent.model.prefs.Prefs;
import com.example.criminalintent.view.MyTextWatcher;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

// TODO add functionality to delete a crime
public class CrimeFragment extends BaseFragment {

    private static final String EXTRA_CRIME_ID = "EXTRA_CRIME_ID";
    private static final String DATE_PICKED_DIALOG_TAG = "DATE_PICKED_DIALOG_TAG";

    public static final String PREFS_LAST_CRIME_ID = "PREFS_LAST_CRIME_ID";

    private final DateFormat dateFormat = SimpleDateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);

    private Crime crime;

    private TextView date;


    public static CrimeFragment newInstance(String crimeId) {
        Bundle args = new Bundle();
        args.putString(EXTRA_CRIME_ID, crimeId);
        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle state) {
        super.onCreate(state);
        String crimeId = getArguments().getString(EXTRA_CRIME_ID);
        crime = CrimeLab.getInstance().getCrime(crimeId);
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

                DatePickerDialogFragment dialog = DatePickerDialogFragment.getInstance(crime.getDateTime());
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
        String dateTime = dateFormat.format(crime.getDateTime());
        date.setText(dateTime);
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        if (childFragment instanceof DatePickerDialogFragment) {
            DatePickerDialogFragment datePickerDialogFragment = (DatePickerDialogFragment) childFragment;
            datePickerDialogFragment.setListener(new DatePickerDialogFragment.Listener() {
                @Override
                public void onNewDateChosen(long dateTime) {
                    crime.setDateTime(dateTime);
                    updateDate();
                }
            });
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        CrimeLab.getInstance().updateCrime(crime);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Prefs.save(PREFS_LAST_CRIME_ID, crime.getId());
    }
}
