package assertions;

/**
 * Нужен для проверок в тесте
 */
public class Assert {
    public static boolean assertEquals(Object firstElement, Object secondElement) {
        return (firstElement.equals(secondElement));
    }
}
