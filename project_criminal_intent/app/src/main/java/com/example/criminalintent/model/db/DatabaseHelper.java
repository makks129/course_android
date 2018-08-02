package com.example.criminalintent.model.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    /**
     * Increment version when you have to apply changes to the database structure
     */
    private static final int VERSION = 1;
    private static final String DB_NAME = "main.db";

    private DatabaseTable[] tables;
    private SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
        tables = new DatabaseTable[]{
                new CrimeTable()
        };
        db = getWritableDatabase();
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        for (DatabaseTable table : tables) {
            table.onCreate(sqLiteDatabase);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        for (DatabaseTable table : tables) {
            table.onUpgrade(sqLiteDatabase, oldVersion, newVersion);
        }
    }

    public CrimeTable getCrimeTable() {
        return (CrimeTable) tables[0];
    }

}
