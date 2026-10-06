package calculator.exception;

public class CalculatorException extends RuntimeException {
    public static class Exit extends CalculatorException {
    }

    public static class Reset extends CalculatorException {
    }
}