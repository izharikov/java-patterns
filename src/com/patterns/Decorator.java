package com.patterns;

/**
 * @author Ihar Zharykau
 */
public class Decorator {
    static void somethingWithShape(Shape shape) {
        shape.draw();
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

interface Shape extends Cloneable {
    void draw();
}

class Circle extends ShapeAbstract{
    @Override
    public void draw() {
        System.out.println("print circle");
    }
}

class Rectangle extends ShapeAbstract{
    @Override
    public void draw() {
        System.out.println("print rectangle");
    }
}

abstract class ShapeAbstract implements Shape{
    @Override
    public Object clone() {
        Object clone = null;

        try {
            clone = super.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }
}