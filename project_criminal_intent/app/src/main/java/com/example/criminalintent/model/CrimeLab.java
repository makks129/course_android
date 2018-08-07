package com.example.criminalintent.model;

import com.example.criminalintent.controller.App;

import java.util.List;
import java.util.UUID;

public class CrimeLab {

    private CrimeLab() {
    }

    private static class SingletonHolder {
        private static final CrimeLab INSTANCE = new CrimeLab();
    }

    public static CrimeLab getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private List<Crime> crimes;

    public List<Crime> getCrimes() {
        if (crimes == null) {
            crimes = App.getDatabaseHelper().getCrimeTable().getCrimes();
        }
        return crimes;
    }

    public int getCrimeIndex(String crimeId) {
        for (int i = 0; i < crimes.size(); i++) {
            Crime crime = crimes.get(i);
            if (crime.getId().equals(crimeId)) {
                return i;
            }
        }
        return 0;
    }

    public Crime getCrime(String crimeId) {
        for (Crime crime : crimes) {
            if (crime.getId().equals(crimeId)) {
                return crime;
            }
        }
        return null;
    }

    public void addCrime(Crime crime) {
        crimes.add(crime);
        App.getDatabaseHelper().getCrimeTable().addCrime(crime);
    }

    public void updateCrime(Crime crime) {
        App.getDatabaseHelper().getCrimeTable().updateCrime(crime);
    }


}
