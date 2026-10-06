package calculator.input_output;

public class ConsoleView {

    public void printWelcome() {
        System.out.println("Добро пожаловать в Калькулятор!");
        System.out.println("Управление: 'C' — сброс, 'S' — выход. Можно вводить на любом этапе!");
    }

    public void promptFirstNumber() {
        System.out.print("Введите первое число: ");
    }

    public void promptOperation() {
        System.out.print("Введите операцию (+, -, *, /) или команду (C, S): ");
    }

    public void promptSecondNumber() {
        System.out.print("Введите второе число: ");
    }

    public void printResult(double result) {
        System.out.println("Результат: " + result);
    }

    public void printUnchangedResult(double result) {
        System.out.println("Текущее состояние результата осталось прежним: " + result);
    }

    public void printDivisionByZeroError() {
        System.out.println("Ошибка: Деление на ноль невозможно! Результат не изменен.");
    }

    public void printInvalidOperationError() {
        System.out.println("Ошибка: Неподдерживаемая операция. Попробуйте еще раз.");
    }

    public void printInputError() {
        System.out.print("Ошибка ввода! Введите число или команду (C, S): ");
    }

    public void printResetMessage() {
        System.out.println("\nРезультат сброшен.");
    }

    public void printExitMessage() {
        System.out.println("\nПрограмма завершена. До свидания!");
    }
}