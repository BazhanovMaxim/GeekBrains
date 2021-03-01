package exceptions;

public class ArrayDontHaveElementException extends RuntimeException{
    public ArrayDontHaveElementException(String message) {
        super(message);
        System.out.println(message);
    }

    public ArrayDontHaveElementException(String message, Throwable cause) {
        super(message, cause);
    }
}
