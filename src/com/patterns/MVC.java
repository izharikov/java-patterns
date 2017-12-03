package com.patterns;

/**
 * @author Ihar Zharykau
 */
public class MVC {
    public static void main(String... args) {
        Controller controller = new Controller();
        MVCAction action = controller.tempAction();
        action.execute();
    }
}

interface MVCAction {
    void execute();
}

class View implements MVCAction {
    private Object model;

    public View(Object model) {
        this.model = model;
    }

    public void execute() {
        System.out.println("render view with model : " + model);
    }
}

class Controller {
    MVCAction tempAction() {
        return new View(new Model("Action"));
    }
}

class Model {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Model(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Model{" +
                "name='" + name + '\'' +
                '}';
    }
}