package prev.firstSecondTasks;

/**
 * Написать метод, который меняет два элемента местами
 *
 * @param <T> тип массива на вход
 */
public class ChangeToElements<T> {
    private final T[] array;

    public ChangeToElements(T[] array) {
        this.array = array;
    }

    /**
     * Метод, который меняет элементы местами
     *
     * @param firstIndex первый индекс элемент
     * @param secondIndex второй индекс элемент
     * @return изменённый массив
     */
    public T[] changeElements(int firstIndex, int secondIndex) {
        T val = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = val;
        return array;
    }
}
