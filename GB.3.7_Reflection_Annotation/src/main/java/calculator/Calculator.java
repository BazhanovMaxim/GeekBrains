package calculator;

public class Calculator {

    public Calculator() {
    }

    // Сложение
    public int SumTwoNumbers(int a, int b) {
        return a + b;
    }

    // Вычитание
    public int subtractTwoNumbers(int a, int b) {
        return a - b;
    }

    // Умножение
    public int multiplyTwoNumbers(int a, int b) {
        return a * b;
    }

    // Деление
    public int divideTwoNumbers(int a, int b) {
        try {
            return a / b;
        } catch (RuntimeException e) {
            throw new ArithmeticException("Второе число равно 0, деление невозможно.");
        }
    }
}
