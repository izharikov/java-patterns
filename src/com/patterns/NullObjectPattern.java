package com.patterns;

import java.util.Random;

/**
 * @author Ihar Zharykau
 */
public class NullObjectPattern {
    public static void main(String... args) {
        BaseRepository repository = new BaseRepository();
        String[] ids = new String[]{"1", "item123", "prod3", "df"};
        for (String id : ids) {
            RepositoryItem item = repository.getItemById(id);
            //  no null checks
            System.out.println(item.getId() + " : " + item.getName());
        }
    }
}

class BaseRepository {
    static Random random = new Random(42);

    RepositoryItem getItemById(String id) {
        int randInt = random.nextInt(10);
        if (randInt % 7 == 4) {
            return new NullRepositoryItem();
        }
        return new BaseRepositoryItem("item_" + Integer.toString(randInt), id);
    }
}

interface RepositoryItem {
    String getName();

    String getId();
}

class BaseRepositoryItem implements RepositoryItem {
    private String name;
    private String id;

    public BaseRepositoryItem(String name, String id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }
}

class NullRepositoryItem implements RepositoryItem {
    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getId() {
        return "";
    }
}