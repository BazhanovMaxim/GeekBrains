import exceptions.ArrayDontHaveElementException;
import exceptions.ArrayHaveInvalidIntegers;
import exceptions.ArrayIsEmptyException;
import org.junit.BeforeClass;
import org.junit.Test;

public class SecondTest {

    private static Second second;
    private static int[] array;

    @BeforeClass
    public static void setUp() {
        second = new Second();
    }

    // Проверка исключения на пустой массив
    @Test(expected = ArrayIsEmptyException.class)
    public void checkArrayIsEmptyException() {
        array = new int[]{};
        second.secondTask(array);
    }

    // Проверка исключения, что в массиве нет 1 или 4
    @Test(expected = ArrayDontHaveElementException.class)
    public void checkArrayDontHaveElementException() {
        array = new int[]{1, 20, 13, 3};
        second.secondTask(array);
    }

    // Проверка исключения, что в массиве есть отличные числа от 1 и 4
    @Test(expected = ArrayHaveInvalidIntegers.class)
    public void checkArrayHaveInvalidIntegers() {
        array = new int[]{1, 10, 4};
        second.secondTask(array);
    }
}
