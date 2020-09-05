package exceptions;

public class ArrayIsEmptyException extends RuntimeException{
    public ArrayIsEmptyException(String message) {
        super(message);
        System.out.println(message);
    }

    public ArrayIsEmptyException(String message, Throwable cause) {
        super(message, cause);
    }
}
