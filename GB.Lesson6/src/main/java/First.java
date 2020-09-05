import exceptions.ArrayDontHaveElementException;
import exceptions.ArrayIsEmptyException;

import java.util.Arrays;

public class First {

    // Индекс изначально равен -1, т.к. в массиве может быть всего 1 элемент: 4
    private static int indexOfLastFour = -1;

    /**
     * 2. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
     * Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
     * идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе
     * необходимо выбросить RuntimeException.
     * Написать набор тестов для этого метода (по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
     *
     * @param array массив элементов
     * @return изменённый новый массив
     */
    public int[] firstTask(int[] array) {
        int[] destination;

        if (array.length == 0) throw new ArrayIsEmptyException("Массив пустой");

        indexOfLastFour = findIndex(array);

        if (indexOfLastFour == -1) throw new ArrayDontHaveElementException("В массиве нет цифры 4");

        destination = copyOfArray(array, indexOfLastFour);
        return destination;
    }

    /**
     * Поиск индекса последней 4-и в массиве
     *
     * @param array массив элемнетов
     * @return индекс
     */
    private int findIndex(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) {
                indexOfLastFour = i;
            }
        }
        return indexOfLastFour;
    }

    /**
     * Копируем в новый массив с определённой позиции
     *
     * @param sourceArray   массив источник
     * @param startPosition индекс, с которого нужно копировать
     * @return новый массив
     */
    private int[] copyOfArray(int[] sourceArray, int startPosition) {
        return Arrays.copyOfRange(sourceArray, startPosition + 1, sourceArray.length);
    }
}
