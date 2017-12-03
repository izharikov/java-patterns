package com.patterns;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ihar Zharykau
 */
public class Prototype {
    public static void main(String... args){
        ShapeCache shapeCache = new ShapeCache();
        shapeCache.getShape("3").draw();
    }
}


class ShapeCache {
    private Map<String, Shape> shapeMap;

    public Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        if (cachedShape instanceof ShapeAbstract) {
            return (Shape) ((ShapeAbstract) cachedShape).clone();
        }
        return null;
    }

    public ShapeCache() {
        initCache();
    }

    public void initCache() {
        shapeMap = new HashMap<>();
        shapeMap.put("1", new Circle());
        shapeMap.put("2", new Rectangle());
        shapeMap.put("3", new Circle());
        shapeMap.put("4", new Rectangle());
    }
}