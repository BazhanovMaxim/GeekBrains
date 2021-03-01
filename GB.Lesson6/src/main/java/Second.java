import exceptions.ArrayDontHaveElementException;
import exceptions.ArrayHaveInvalidIntegers;
import exceptions.ArrayIsEmptyException;

public class Second {

    /**
     * 3. Написать метод, который проверяет состав массива из чисел 1 и 4.
     * Если в нем нет хоть одной четверки или единицы, то метод вернет false;
     * Написать набор тестов для этого метода (по 3-4 варианта входных данных).
     */
    public int[] secondTask(int[] array) {
        if (array.length == 0) throw new ArrayIsEmptyException("Массив пустой");

        if (!checkElements(array)) throw new ArrayDontHaveElementException("В массиве нет числа 1 или 4");

        if (!checkArrayToAnotherElement(array)) throw new ArrayHaveInvalidIntegers("В массиве есть числа/число отличные(ое) от 1 и 4");

        return array;
    }

    /**
     * Проверяем, что в массиве есть числа: 1 и 4
     * @param array входящий массив
     * @return boolean. True - в массиве есть проверяемые числа. False - в массиве нет какого-то числа
     */
    private boolean checkElements(int[] array){
        int counterOfOne = 0;
        int counterOfFour = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) counterOfOne++;
            else counterOfFour++;
        }
        return counterOfFour != 0 && counterOfOne != 0;
    }

    /**
     * Проверяем, что в массиве нет других чисел кроме: 1 и 4
     *
     * @param array входящий массив
     * @return boolean. True - массив только из 1 и 4. False - в массиве есть другие числа
     */
    private boolean checkArrayToAnotherElement(int[] array){
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 1 && array[i] != 4) return false;
        }
        return true;
    }
}
