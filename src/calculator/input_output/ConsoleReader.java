package calculator.input_output;

import calculator.exception.CalculatorException;

import java.util.Scanner;

public class ConsoleReader {

    private final Scanner scanner;
    private final ConsoleView view;

    public ConsoleReader(Scanner scanner, ConsoleView view) {
        this.scanner = scanner;
        this.view = view;
    }

    public String readInputOrCommand() {
        String input = scanner.next();

        if (input.equalsIgnoreCase("s")) {
            throw new CalculatorException.Exit();
        }
        if (input.equalsIgnoreCase("c")) {
            throw new CalculatorException.Reset();
        }

        return input;
    }

    public double readDouble() {
        while (true) {
            String input = readInputOrCommand();
            input = input.replace(',', '.');

            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                view.printInputError();
            }
        }
    }
}