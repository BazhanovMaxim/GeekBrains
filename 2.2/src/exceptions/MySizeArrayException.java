package exceptions;

public class MySizeArrayException extends Exception{
    public MySizeArrayException(String message) {
        super(message);
    }

    public MySizeArrayException(String message, Throwable cause) {
        super(message, cause);
    }
}
