package exceptions;

public class AssertEqualsException extends Exception {
    public AssertEqualsException(String message) {
        super(message);
    }

    public AssertEqualsException(String message, Throwable cause) {
        super(message, cause);
    }
}
