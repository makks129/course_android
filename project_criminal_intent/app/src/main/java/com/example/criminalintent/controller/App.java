package com.example.criminalintent.controller;

import android.app.Application;
import android.util.Log;

import com.example.criminalintent.model.db.DatabaseHelper;

public class App extends Application {

    private static final String TAG = "TAG_" + App.class.getSimpleName();

    private static App app;
    private DatabaseHelper databaseHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");

        app = this;
        databaseHelper = new DatabaseHelper(this);
    }


    public static App get() {
        return app;
    }

    public static DatabaseHelper getDatabaseHelper() {
        return get().databaseHelper;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d(TAG, "onTerminate");
    }
}
