package com.patterns;

/**
 * @author Ihar Zharykau
 */
public final class Builder {
    private BuildEntity entity;

    public static Builder createBuilder() {
        return new Builder(new BuildEntity());
    }

    public Builder addSize(int size) {
        entity.setSize(size);
        return this;
    }

    public Builder addName(String name) {
        entity.setName(name);
        return this;
    }

    public BuildEntity Build() {
        return entity;
    }

    private Builder(BuildEntity entity) {
        this.entity = entity;
    }
}

class BuildEntity {
    private int size;
    private String name;

    BuildEntity() {
    }

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
}

class Main {
    public static void main(String... args) {
        BuildEntity entity = Builder
                .createBuilder()
                .addName("sample name")
                .addSize(12)
                .Build();
    }
}