package com.example.criminalintent.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CrimeLab {

    private static CrimeLab crimeLab;

    public static CrimeLab getInstance() {
        if (crimeLab == null) {
            crimeLab = new CrimeLab();
        }
        return crimeLab;
    }

    private List<Crime> crimes;

    private CrimeLab() {
        crimes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("Title " + i);
            crime.setCalendar(Calendar.getInstance());
            crime.setSolved(i % 2 == 0);
            crimes.add(crime);
        }
    }


}
