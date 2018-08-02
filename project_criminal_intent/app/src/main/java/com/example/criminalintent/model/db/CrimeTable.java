package com.example.criminalintent.model.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.example.criminalintent.model.Crime;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class CrimeTable extends DatabaseTable {

    static final String TABLE_NAME = "crimes";

    static final String ID = "uuid";
    static final String TITLE = "title";
    static final String TIME = "time";
    static final String SOLVED = "solved";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" +
                " _id integer PRIMARY KEY AUTOINCREMENT, " +
                ID + ", " +
                TITLE + ", " +
                TIME + ", " +
                SOLVED +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // nothing here yet
    }

    public void addCrime(Crime crime) {
        ContentValues values = getContentValues(crime);
        getDb().insert(TABLE_NAME, null, values);
    }

    public void updateCrime(Crime crime) {
        String uuidString = crime.getUuid().toString();
        ContentValues values = getContentValues(crime);
        getDb().update(TABLE_NAME, values,
                ID + " = ?", new String[]{uuidString}); // SQL injection defence
    }

    public Crime getCrime(UUID uuid) {
        Cursor cursor = queryCrimes(
                ID + " = ?",
                new String[]{uuid.toString()}
        );
        try {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                return getCrimeFromCursor(cursor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cursor.close();
        }
        return null;
    }

    public List<Crime> getCrimes() {
        List<Crime> crimes = new ArrayList<>();
        Cursor cursor = queryCrimes(null, null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Crime crime = getCrimeFromCursor(cursor);
                crimes.add(crime);
                cursor.moveToNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cursor.close();
        }
        return crimes;
    }

    private Crime getCrimeFromCursor(Cursor c) {
        String uuidString = c.getString(c.getColumnIndex(ID));
        String title = c.getString(c.getColumnIndex(TITLE));
        long time = c.getLong(c.getColumnIndex(TIME));
        int isSolved = c.getInt(c.getColumnIndex(SOLVED));

        UUID uuid = UUID.fromString(uuidString);
        Crime crime = new Crime(uuid);
        crime.setTitle(title);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        crime.setCalendar(calendar);
        crime.setSolved(isSolved != 0);
        return crime;
    }

    private Cursor queryCrimes(String where, String[] whereArgs) {
        return getDb().query(
                TABLE_NAME,
                null, // columns - null selects all columns
                where,
                whereArgs,
                null, // groupBy
                null, // having
                null  // orderBy
        );
    }

    @NonNull
    private ContentValues getContentValues(Crime crime) {
        ContentValues values = new ContentValues();
        values.put(ID, crime.getUuid().toString());
        values.put(TITLE, crime.getTitle());
        values.put(TIME, crime.getCalendar().getTimeInMillis());
        values.put(SOLVED, crime.isSolved() ? 1 : 0);
        return values;
    }

}
