import exceptions.ArrayDontHaveElementException;
import exceptions.ArrayIsEmptyException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FirstTest {

    private static First first;
    private static int[] array;

    @BeforeClass
    public static void setUp() {
        first = new First();
    }

    // Проверка исключения на пустой массив
    @Test(expected = ArrayIsEmptyException.class)
    public void checkArrayIsEmptyException() {
        array = new int[]{};
        first.firstTask(array);
    }

    // Проверка исключения, что в массиве нет 4-и
    @Test(expected = ArrayDontHaveElementException.class)
    public void checkArrayDontHaveElementException() {
        array = new int[]{1, 20, 13, 3};
        first.firstTask(array);
    }

    // Проверка выходного значения (длины = 3)
    @Test
    public void shouldReturnArrayWithThreeElements() {
        array = new int[] {1, 2, 5, 4, 1, 2, 4, 2, 10, 1};
        Assert.assertEquals(first.firstTask(array).length, 3);
    }

    // Проверка выходного значения (длины = 0)
    @Test
    public void shouldReturnArrayWithZeroElement(){
        array = new int[] {4};
        Assert.assertEquals(first.firstTask(array).length, 0);
    }
}
