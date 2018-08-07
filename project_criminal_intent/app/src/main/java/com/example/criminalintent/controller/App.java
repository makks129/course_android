package com.example.criminalintent.controller;

import android.app.Application;
import android.util.Log;

import com.example.criminalintent.model.db.DatabaseHelper;
import com.example.criminalintent.model.network.NetworkHelper;

public class App extends Application {

    private static final String TAG = "TAG_" + App.class.getSimpleName();

    private static App app;
    private DatabaseHelper databaseHelper;
    private NetworkHelper networkHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");

        app = this;
        databaseHelper = new DatabaseHelper(this);
        networkHelper = new NetworkHelper();
    }


    public static App get() {
        return app;
    }

    public static DatabaseHelper getDatabaseHelper() {
        return get().databaseHelper;
    }

    public static NetworkHelper getNetworkHelper() {
        return get().networkHelper;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d(TAG, "onTerminate");
    }
}
