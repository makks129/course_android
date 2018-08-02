package com.example.criminalintent.model.singleton;

/**
 * + lazy, thread-safe, fast
 * - complicated
 */
public class SingletonLazyDoubleCheck {

    private static volatile SingletonLazyDoubleCheck instance;

    private SingletonLazyDoubleCheck() {
    }

    public static SingletonLazyDoubleCheck getInstance() {
        SingletonLazyDoubleCheck localInstance = instance;
        if (localInstance == null) {
            synchronized (SingletonLazyDoubleCheck.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new SingletonLazyDoubleCheck();
                }
            }
        }
        return localInstance;
    }

}
