package com.patterns;

/**
 * @author Ihar Zharykau
 */
public class IteratorPattern {
    public static void main(String... args){
        ArrayIterator<String> iterator = new ArrayIterator<>("23", "dsfsfds", "llpas");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

interface CustomIterator<T> {
    T next();

    boolean hasNext();
}

class ArrayIterator<T> implements CustomIterator<T> {
    private int currentIndex;
    private T[] source;

    @SafeVarargs
    public ArrayIterator(T... source) {
        currentIndex = 0;
        this.source = source;
    }

    @Override
    public T next() {
        return source[currentIndex++];
    }

    @Override
    public boolean hasNext() {
        return currentIndex < source.length;
    }
}