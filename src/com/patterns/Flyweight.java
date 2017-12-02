package com.patterns;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ihar Zharykau
 */
public class Flyweight {
    public static void main(String... args){
        ShapeFactory factory = ShapeFactory.getInstance();
        Shape shape1 = factory.getShape("circle");
        Shape shape2 = factory.getShape("circle");
        System.out.println(shape1 == shape2);
    }
}

class ShapeFactory {
    private Map<String, Shape> store = new HashMap<>();

    public Shape getShape(String type) {
        Shape shape = store.get(type);
        if ( shape == null){
            shape = createByType(type);
            store.put(type, shape);
        }
        return shape;
    }

    private Shape createByType(String type) {
        switch (type) {
            case "rectangle":
                return new Rectangle();
            case "circle":
                return new Circle();
        }
        return null;
    }

    private ShapeFactory() {
    }

    private static ShapeFactory inst;

    static {
        inst = new ShapeFactory();
    }

    public static ShapeFactory getInstance() {
        return inst;
    }
}
