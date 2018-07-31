package com.example.criminalintent.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

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

    public Crime getCrime(UUID crimeId) {
        for (Crime crime : crimes) {
            if (crime.getUuid().equals(crimeId)) {
                return crime;
            }
        }
        return null;
    }

    public int getCrimeIndex(UUID crimeId) {
        for (int i = 0; i < crimes.size(); i++) {
            Crime crime = crimes.get(i);
            if (crime.getUuid().equals(crimeId)) {
                return i;
            }
        }
        return 0;
    }

    public void addCrime(Crime crime) {
        crimes.add(crime);
    }

    public List<Crime> getCrimes() {
        return crimes;
    }

    public void setCrimes(List<Crime> crimes) {
        this.crimes = crimes;
    }
}
