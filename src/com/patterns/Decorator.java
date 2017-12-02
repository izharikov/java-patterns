package com.patterns;

/**
 * @author Ihar Zharykau
 */
public class Decorator {
    static void somethingWithShape(Shape shape) {
        shape.draw();
    }
}

interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("print circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("print rectangle");
    }
}

abstract class ShapeDecorator implements Shape {
    private Shape shape;

    public ShapeDecorator(Shape decoratedShape) {
        this.shape = decoratedShape;
    }

    @Override
    public void draw() {
        shape.draw();
    }
}

class WrapperDecorator extends ShapeDecorator {

    public WrapperDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        System.out.println("add some additional behaviour");
        super.draw();
    }
}
