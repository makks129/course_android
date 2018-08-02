package com.example.criminalintent.model.singleton;

/**
 * + lazy
 * - slow (uses synchronized on every getInstance call)
 */
public class SingletonLazySync {

    private static SingletonLazySync instance;

    private SingletonLazySync() {
    }

    public static synchronized SingletonLazySync getInstance() {
        if (instance == null) {
            instance = new SingletonLazySync();
        }
        return instance;
    }

}
