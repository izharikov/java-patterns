package com.patterns;

/**
 * @author Ihar Zharykau
 */
public class InterpreterPattern {
    public static void main(String... args) {
        ExpressionInterpreter interpreter = new ExpressionInterpreter();
        BinExpression<Integer> plus = interpreter.interpret("plus");
        if (plus != null) {
            System.out.println(plus.evaluate(10, 20));
        }
    }
}

interface BinExpression<T> {
    T evaluate(T first, T second);
}

class AddExpression implements BinExpression<Integer> {
    @Override
    public Integer evaluate(Integer first, Integer second) {
        return first + second;
    }
}

class MinusExpression implements BinExpression<Integer> {
    @Override
    public Integer evaluate(Integer first, Integer second) {
        return first - second;
    }
}

interface Interpreter<S, T> {
    T interpret(S source);
}

class ExpressionInterpreter implements Interpreter<String, BinExpression<Integer>> {
    @Override
    public BinExpression<Integer> interpret(String source) {
        BinExpression<Integer> expression = null;
        switch (source) {
            case "plus":
                expression = new AddExpression();
                break;
            case "minus":
                expression = new MinusExpression();
                break;
        }
        return expression;
    }
}
