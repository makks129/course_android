package com.example.criminalintent.model.db;

import android.database.sqlite.SQLiteDatabase;

import com.example.criminalintent.controller.App;

public abstract class DatabaseTable {

    /**
     * On create table logic
     */
    public abstract void onCreate(SQLiteDatabase db);

    /**
     * On update table from old to new version logic
     */
    public abstract void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);

    protected SQLiteDatabase getDb() {
        return App.getDatabaseHelper().getDb();
    }

}
