package com.example.criminalintent.model.singleton;

/**
 * + simple, fast, thread-safe, lazy
 */
public class SingletonLazyHolder {

    private SingletonLazyHolder() {
    }

    private static class SingletonHolder {
        private static final SingletonLazyHolder INSTANCE = new SingletonLazyHolder();
    }

    public static SingletonLazyHolder getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
