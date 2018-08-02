package com.example.criminalintent.controller;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.support.v4.content.LocalBroadcastManager;

/**
 * For more on Context see:
 * <a href="https://medium.freecodecamp.org/mastering-android-context-7055c8478a22"/>
 */
public class Ctxt {

    public static Context get() {
        return App.get();
    }

    public static String getString(int resId) {
        return get().getString(resId);
    }

    public static String getString(int resId, Object... formatArgs) {
        return get().getString(resId, formatArgs);
    }

    public static String getQuantityString(int resId, int quantity, Object... formatArgs) {
        return getResources().getQuantityString(resId, quantity, formatArgs);
    }

    private static Resources getResources() {
        return get().getResources();
    }

    private static AssetManager getAssets() {
        return get().getAssets();
    }

    public static PackageManager getPackageManager() {
        return get().getPackageManager();
    }

    public static ContentResolver getContentResolver() {
        return get().getContentResolver();
    }

    public static Object getSystemService(String name) {
        return get().getSystemService(name);
    }

    public static void sendLocalBroadcast(Intent intent) {
        LocalBroadcastManager.getInstance(get()).sendBroadcast(intent);
    }


}
