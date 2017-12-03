package com.patterns;

/**
 * @author Ihar Zharykau
 */
public class CompositeEntityPattern {
    public static void main(String... args){
        CompositeEntity entity = new CompositeEntity();
        entity.setData("some data");
        entity.setName("Name");
        System.out.println("data : " + entity.getData() + "; name : " + entity.getName());
    }
}

class DependentObjectFirst {
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

class DependentObjectSecond {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class CoarseGrainedObject {
    private DependentObjectFirst first = new DependentObjectFirst();
    private DependentObjectSecond second = new DependentObjectSecond();

    public void setName(String name) {
        second.setName(name);
    }

    public String getData() {
        return first.getData();
    }

    public void setData(String data) {
        first.setData(data);
    }

    public String getName() {
        return second.getName();
    }
}

class CompositeEntity {
    private CoarseGrainedObject cgo = new CoarseGrainedObject();

    public void setData(String data) {
        cgo.setData(data);
    }

    public String getData() {
        return cgo.getData();
    }

    public String getName() {
        return cgo.getName();
    }

    public void setName(String name) {
        cgo.setName(name);
    }
}