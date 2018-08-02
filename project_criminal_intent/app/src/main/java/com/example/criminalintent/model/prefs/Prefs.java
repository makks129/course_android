package com.example.criminalintent.model.prefs;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;

import com.example.criminalintent.controller.Ctxt;

public class Prefs {

    public enum Default {STRING, INT, LONG, FLOAT, BOOLEAN}

    private static final String DEFAULT_STRING = null;
    private static final Integer DEFAULT_INT = -1;
    private static final Long DEFAULT_LONG = -1L;
    private static final Float DEFAULT_FLOAT = -1F;
    private static final Boolean DEFAULT_BOOLEAN = false;

    /**
     * Saves key-value pair to shared prefs
     * To save default values use {@link Default}
     * Note: check value for null first - null values are not saved
     */
    public static void save(String key, @NonNull Object value) {
        SharedPreferences.Editor editor = getSharedPrefs().edit();
        if (value instanceof Default) {
            Default defValue = (Default) value;
            if (defValue == Default.STRING) editor.putString(key, DEFAULT_STRING);
            if (defValue == Default.INT) editor.putInt(key, DEFAULT_INT);
            if (defValue == Default.LONG) editor.putLong(key, DEFAULT_LONG);
            if (defValue == Default.FLOAT) editor.putFloat(key, DEFAULT_FLOAT);
            if (defValue == Default.BOOLEAN) editor.putBoolean(key, DEFAULT_BOOLEAN);
        }
        if (value instanceof String) editor.putString(key, (String) value);
        if (value instanceof Integer) editor.putInt(key, (Integer) value);
        if (value instanceof Long) editor.putLong(key, (Long) value);
        if (value instanceof Float) editor.putFloat(key, (Float) value);
        if (value instanceof Boolean) editor.putBoolean(key, (Boolean) value);
        editor.apply();
    }

    public static <T> void save(int keyResId, @NonNull T value) {
        save(Ctxt.getString(keyResId), value);
    }

    public static String getString(String key) {
        return getSharedPrefs().getString(key, DEFAULT_STRING);
    }

    public static String getString(int stringId) {
        return getString(Ctxt.getString(stringId));
    }

    public static int getInt(String key) {
        return getSharedPrefs().getInt(key, DEFAULT_INT);
    }

    public static int getInt(int keyResId) {
        return getInt(Ctxt.getString(keyResId));
    }

    public static long getLong(String key) {
        return getSharedPrefs().getLong(key, DEFAULT_LONG);
    }

    public static long getLong(int keyResId) {
        return getLong(Ctxt.getString(keyResId));
    }

    public static float getFloat(String key) {
        return getSharedPrefs().getFloat(key, DEFAULT_FLOAT);
    }

    public static float getFloat(int keyResId) {
        return getFloat(Ctxt.getString(keyResId));
    }

    public static boolean getBoolean(String key) {
        return key != null && getSharedPrefs().getBoolean(key, DEFAULT_BOOLEAN);
    }

    public static boolean getBoolean(String key, boolean defValue) {
        return key != null && getSharedPrefs().getBoolean(key, defValue);
    }

    public static boolean getBoolean(int keyResId) {
        return getBoolean(Ctxt.getString(keyResId));
    }

    public static boolean getBoolean(int keyResId, boolean defValue) {
        return getBoolean(Ctxt.getString(keyResId), defValue);
    }

    public static SharedPreferences getSharedPrefs() {
        return PreferenceManager.getDefaultSharedPreferences(Ctxt.get());
    }

}
