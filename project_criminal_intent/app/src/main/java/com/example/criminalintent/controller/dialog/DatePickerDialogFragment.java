package com.example.criminalintent.controller.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import com.example.criminalintent.R;
import com.example.criminalintent.controller.dialog.base.BaseDialogFragment;

import java.util.Calendar;

public class DatePickerDialogFragment extends BaseDialogFragment {

    private static final String EXTRA_DATE = "EXTRA_DATE";

    private Calendar calendar;
    private Listener listener;


    public static DatePickerDialogFragment getInstance(Calendar calendar) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_DATE, calendar);
        DatePickerDialogFragment fragment = new DatePickerDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle state) {
        super.onCreate(state);
        calendar = (Calendar) getArguments().getSerializable(EXTRA_DATE);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle state) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_date_picker, null);
        final DatePicker datePicker = view.findViewById(R.id.datePicker);
        datePicker.init(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH),
                null);

        builder.setTitle(R.string.date_of_crime)
                .setView(view)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Calendar newCalendar = Calendar.getInstance();
                        newCalendar.set(Calendar.YEAR, datePicker.getYear());
                        newCalendar.set(Calendar.MONTH, datePicker.getMonth());
                        newCalendar.set(Calendar.DAY_OF_MONTH, datePicker.getDayOfMonth());

                        if (listener != null) {
                            listener.onNewDateChosen(newCalendar);
                        }
//                        Fragment parentFragment = getParentFragment();
//                        if (parentFragment != null && parentFragment instanceof CrimeFragment) {
//                            CrimeFragment crimeFragment = (CrimeFragment) parentFragment;
//
//                        }
                    }
                })
                .setNegativeButton(android.R.string.cancel, null);

        return builder.create();
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public interface Listener {
        void onNewDateChosen(Calendar newCalendar);
    }
}
