package com.patterns;

/**
 * @author Ihar Zharykau
 */
//  TODO: change, as it's wrong implementation
public class Prototype {
    private Prototype() {
    }

    public Prototype newInstance() {
        return new Prototype();
    }
}
