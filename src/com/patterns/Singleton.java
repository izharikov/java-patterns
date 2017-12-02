package com.patterns;

/**
 * @author Ihar Zharykau
 */
public class Singleton {
    private static Singleton instance;

    public static Singleton getInstance() {
        return instance;
    }

    static {
        instance = new Singleton();
    }

    private Singleton(){}
}
