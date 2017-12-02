package com.patterns;

import java.util.LinkedList;

/**
 * @author Ihar Zharykau
 */
public class Memento {
    public static void main(String... args) {
        StateObject obj = new StateObject("initial");
        MementoStateWrapper wrapper = new MementoStateWrapper(obj);
        String[] states = new String[]{"first", "second", "failed"};
        for (String state : states) {
            wrapper.setState(state);
            System.out.println("Current obj state : " + obj.getState());
            if ( obj.getState().equals("failed")){
                wrapper.restoreState();
                System.out.println("Successfully restore state. Current state: " + obj.getState());
            }
        }
    }
}

class StateObject {
    private String state;

    public StateObject(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

class MementoStateWrapper {
    private LinkedList<String> states;
    private StateObject stateObject;

    public MementoStateWrapper(StateObject stateObject) {
        states = new LinkedList<>();
        this.stateObject = stateObject;
    }

    public void setState(String state) {
        states.add(stateObject.getState());
        stateObject.setState(state);
    }

    public void restoreState() {
        stateObject.setState(states.removeLast());
    }

    public StateObject getStateObject() {
        return stateObject;
    }
}