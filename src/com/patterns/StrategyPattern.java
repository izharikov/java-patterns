package com.patterns;

/**
 * @author Ihar Zharykau
 */
public class StrategyPattern {
    public static void main(String... args){
        StrategyContext context = new StrategyContext();
        context.setCurrentStrategy(new DoubleString());
        System.out.println(context.execute("dafdsfsd"));
        context.setCurrentStrategy(new FirstSymbolString());
        System.out.println(context.execute("abcd"));
    }
}

class StrategyContext{
    private Strategy<String, String> currentStrategy;

    public String execute(String str){
        return currentStrategy.algorithm(str);
    }

    public void setCurrentStrategy(Strategy<String, String> currentStrategy) {
        this.currentStrategy = currentStrategy;
    }
}

interface Strategy<T, S> {
    S algorithm(T obj);
}

interface StringStrategy extends Strategy<String, String> {
}

class DoubleString implements StringStrategy {
    @Override
    public String algorithm(String obj) {
        return obj + obj;
    }
}

class FirstSymbolString implements StringStrategy {
    @Override
    public String algorithm(String obj) {
        return obj.length() > 0 ? obj.substring(0, 1) : "";
    }
}
