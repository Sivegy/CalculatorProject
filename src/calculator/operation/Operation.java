package calculator.operation;

import java.util.function.DoubleBinaryOperator;

public enum Operation {
    PLUS('+', Double::sum),
    MINUS('-', (a, b) -> a - b),
    MULTIPLY('*', (a, b) -> a * b),
    DIVIDE('/', (a, b) -> {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль!");
        }
        return a / b;
    });

    private final char symbol;
    private final DoubleBinaryOperator action;

    Operation(char symbol, DoubleBinaryOperator action) {
        this.symbol = symbol;
        this.action = action;
    }

    public double apply(double a, double b) {
        return action.applyAsDouble(a, b);
    }

    public static Operation fromSymbol(char symbol) {
        for (Operation op : values()) {
            if (op.symbol == symbol) {
                return op;
            }
        }
        throw new IllegalArgumentException("Неизвестная операция: " + symbol);
    }
}