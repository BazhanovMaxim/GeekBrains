package exceptions;

public class ArrayHaveInvalidIntegers extends RuntimeException {
    public ArrayHaveInvalidIntegers(String message) {
        super(message);
        System.out.println(message);
    }

    public ArrayHaveInvalidIntegers(String message, Throwable cause) {
        super(message, cause);
    }
}
