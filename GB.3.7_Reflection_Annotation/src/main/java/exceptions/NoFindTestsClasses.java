package exceptions;

public class NoFindTestsClasses extends RuntimeException {
    public NoFindTestsClasses(String message) {
        super(message);
    }

    public NoFindTestsClasses(String message, Throwable cause) {
        super(message, cause);
    }
}
