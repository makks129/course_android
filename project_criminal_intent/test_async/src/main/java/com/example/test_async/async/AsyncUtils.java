package com.example.test_async.async;

import android.os.Looper;
import android.os.SystemClock;

public class AsyncUtils {

    public static void sleep(long millis) {
        SystemClock.sleep(millis);
    }

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

}
