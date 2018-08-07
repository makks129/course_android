package com.example.criminalintent.model.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.example.criminalintent.model.Crime;

import java.util.ArrayList;
import java.util.List;

public class CrimeTable extends DatabaseTable {

    static final String TABLE_NAME = "crimes";

    static final String ID = "id";
    static final String TITLE = "title";
    static final String DATE_TIME = "date_time";
    static final String SOLVED = "solved";
    static final String IMAGE_URL = "image_url";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" +
                " id_primary_key_autoincrement integer PRIMARY KEY AUTOINCREMENT, " +
                ID + ", " +
                TITLE + ", " +
                DATE_TIME + ", " +
                SOLVED +
                IMAGE_URL +
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
        String idString = crime.getId();
        ContentValues values = getContentValues(crime);
        getDb().update(TABLE_NAME, values,
                ID + " = ?", new String[]{idString}); // SQL injection defence
    }

    public Crime getCrime(String id) {
        Cursor cursor = queryCrimes(
                ID + " = ?",
                new String[]{id}
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
        String idString = c.getString(c.getColumnIndex(ID));
        String title = c.getString(c.getColumnIndex(TITLE));
        long dateTime = c.getLong(c.getColumnIndex(DATE_TIME));
        int isSolved = c.getInt(c.getColumnIndex(SOLVED));
        String imageUrl = c.getString(c.getColumnIndex(IMAGE_URL));

        Crime crime = new Crime(idString);
        crime.setTitle(title);
        crime.setDateTime(dateTime);
        crime.setSolved(isSolved != 0);
        crime.setImageUrl(imageUrl);
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
        values.put(ID, crime.getId());
        values.put(TITLE, crime.getTitle());
        values.put(DATE_TIME, crime.getDateTime());
        values.put(SOLVED, crime.isSolved() ? 1 : 0);
        values.put(IMAGE_URL, crime.getImageUrl());
        return values;
    }

}
