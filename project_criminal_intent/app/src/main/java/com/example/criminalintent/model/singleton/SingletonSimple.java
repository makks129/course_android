package com.example.criminalintent.model.singleton;

/**
 * + simple, thread-safe, fast
 * - not lazy
 */
public class SingletonSimple {

    public static final SingletonSimple INSTANCE = new SingletonSimple();

    private SingletonSimple() {
    }

    public static SingletonSimple getInstance() {
        return INSTANCE;
    }

}
