package prev.firstSecondTasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Написать метод, который преобразует массив в ArrayList;
 *
 * @param <E> тип массива на вход
 */
public class ArrayToList<E> {
    private final List<E> dynamicArray = new ArrayList<>();

    public ArrayToList(E[] array) {
        dynamicArray.addAll(Arrays.asList(array));
    }

    public void getList() {
        System.out.printf("ArrayList: %s", dynamicArray);
    }
}
