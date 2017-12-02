package com.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ihar Zharykau
 */
public class Observer {
    public static void main(String... args) {
        Subject subject = new Subject();
        subject.addObserver(obj -> {
            System.out.println("1st observer: " + obj.getState());
        });
        subject.addObserver(obj -> {
            System.out.println("2nd observer: " + obj.getState());
        });
        subject.setState("some state");
        subject.setState("another state changed");
    }
}

interface ObserverObj {
    void callback(Subject obj);
}

class Subject {
    private List<ObserverObj> observers;

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        String prevState = this.state;
        this.state = state;
        //  check if observer calls setState with the same value
        if (!state.equals(prevState)) {
            notifyObservers();
        }
    }

    public Subject() {
        observers = new ArrayList<>();
    }

    public void addObserver(ObserverObj obj) {
        observers.add(obj);
    }

    public void removeObserver(ObserverObj obj) {
        observers.remove(obj);
    }

    void notifyObservers() {
        observers.forEach(obs -> obs.callback(this));
    }
}