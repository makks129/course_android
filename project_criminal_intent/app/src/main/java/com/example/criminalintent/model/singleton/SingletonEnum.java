package com.example.criminalintent.model.singleton;

/**
 * + simple, thread-safe, fast
 * - not lazy
 */
public enum  SingletonEnum {
    INSTANCE;

    public static SingletonEnum getInstance() {
        return INSTANCE;
    }
}
