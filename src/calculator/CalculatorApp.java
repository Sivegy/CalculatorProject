package calculator;

import calculator.exception.CalculatorException;
import calculator.input_output.ConsoleReader;
import calculator.input_output.ConsoleView;
import calculator.operation.Operation;

import java.util.Scanner;

public class CalculatorApp {

    private final ConsoleView view;
    private final ConsoleReader reader;
    private double currentResult;
    private boolean isFirstRun;

    public CalculatorApp() {
        Scanner scanner = new Scanner(System.in);
        this.view = new ConsoleView();
        this.reader = new ConsoleReader(scanner, this.view);
        this.currentResult = 0;
        this.isFirstRun = true;
    }

    public void run() {
        view.printWelcome();

        while (true) {
            try {
                // 1. Ввод первого числа
                if (isFirstRun) {
                    view.promptFirstNumber();
                    currentResult = reader.readDouble();
                    isFirstRun = false;
                }

                // 2. Ввод операции
                view.promptOperation();
                String input = reader.readInputOrCommand();

                Operation operation;
                try {
                    if (input.length() != 1) {
                        throw new IllegalArgumentException();
                    }
                    operation = Operation.fromSymbol(input.charAt(0));
                } catch (IllegalArgumentException e) {
                    view.printInvalidOperationError();
                    continue;
                }

                // 3. Ввод второго числа
                view.promptSecondNumber();
                double operand2 = reader.readDouble();

                // 4. Вычисление результата
                try {
                    currentResult = operation.apply(currentResult, operand2);
                    view.printResult(currentResult);
                } catch (ArithmeticException e) {
                    view.printDivisionByZeroError();
                    view.printUnchangedResult(currentResult);
                }

            } catch (CalculatorException.Reset e) {
                view.printResetMessage();
                isFirstRun = true;
            } catch (CalculatorException.Exit e) {
                view.printExitMessage();
                break;
            }
        }
    }
}