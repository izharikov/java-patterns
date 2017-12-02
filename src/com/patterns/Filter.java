package com.patterns;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author Ihar Zharykau
 */
public class Filter {
    public static void main(String... args) {
        Collection<Entity> collection = new ArrayList<>();
        collection.add(new Entity(10, "entity #1"));
        collection.add(new Entity(25, "entity #2"));
        collection.add(new Entity(35, "entity #3"));
        collection.add(new Entity(21, "entity #4"));
        Criteria<Entity> largerThan20 = new LargerSizeCriteria(20);
        Criteria<Entity> lessThan20 = largerThan20.inverse();
        System.out.println(largerThan20.filter(collection));
        System.out.println(lessThan20.filter(collection));
    }
}

interface Criteria<T> {
    boolean match(T obj);

    default Criteria<T> and(Criteria<T> another) {
        return (obj) -> match(obj) && another.match(obj);
    }

    default Criteria<T> or(Criteria<T> another) {
        return (obj) -> match(obj) || another.match(obj);
    }

    default Criteria<T> inverse() {
        return obj -> !match(obj);
    }

    default Collection<T> filter(Collection<T> collection) {
        return collection
                .stream()
                .filter(this::match)
                .collect(Collectors.toList());
    }
}

class LargerSizeCriteria implements Criteria<Entity> {
    private int minSize;

    public int getMinSize() {
        return minSize;
    }

    public LargerSizeCriteria(int minSize) {
        this.minSize = minSize;
    }

    @Override
    public boolean match(Entity obj) {
        return obj.getSize() > minSize;
    }
}


class Entity {
    private int size;
    private String name;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Entity() {
    }

    public Entity(int size, String name) {
        this.size = size;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "size=" + size +
                ", name='" + name + '\'' +
                '}';
    }
}
