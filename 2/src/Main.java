import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        // Первое задание
        int[] newArray_firstTask = new int[] {1, 0, 1, 1};
        changeArrayElement(newArray_firstTask);
        System.out.println("\nПервое задание: ");
        System.out.println(Arrays.toString(newArray_firstTask));

        // Второе задание (2 решения: с циклом и без)
        int[] variableArray_secondTask = new int[8];
        int[] newElementsOfTheArray_secondTask = new int[] {0, 3, 6, 9, 12, 15, 18, 21};
        addElementsToArray(variableArray_secondTask, newElementsOfTheArray_secondTask);
        System.out.println("\nВторое задание: ");
        System.out.println(Arrays.toString(variableArray_secondTask));
        // Второй вариант решения
        int[] variableArray2_secondTask = Arrays.copyOf(newElementsOfTheArray_secondTask, 8);
        System.out.println(Arrays.toString(variableArray2_secondTask));

        // Третье задание
        int[] array_thirdTask = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        changeElementsBelowSix(array_thirdTask);
        System.out.println("\nТретье задание: ");
        System.out.println(Arrays.toString(array_thirdTask));

        // Четвёртое задание
        int [][] twoDimArray_fourthTask = {{10, 10, 10}, {9, 9, 9}, {8, 8, 8}};
        System.out.println("\nЧетвёртое задание: ");
        changeDiagonal(twoDimArray_fourthTask);

        // Пятое задание
        int[] array_fifthTask = new int[] {0, -1, 20, 100, -100, 101};
        System.out.println("\nПятое задание: ");
        maxInArray(array_fifthTask);
        minInArray(array_fifthTask);

        // Шестое задание
        System.out.println("\nШестое задание");
        System.out.println(checkBalance(new int[] {2, 2, 2, 1, 2, 2, 10, 1}));
        System.out.println("Сумма массива: " + sumOfArray);
        System.out.println("Сумма левой части: " + leftPath + " позиция: " + position);
    }

    /**
     *  Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
     *  С помощью цикла и условия заменить 0 на 1, 1 на 0;
     * @param array массив элементов
     * @return возвращаем измененённый массив элементов
     */
    public static int[] changeArrayElement (int[] array){
        for (int i = 0; i < array.length; i++){
            if (array[i] == 0) array[i] = 1;
            else array[i] = 0;
        }
        return array;
    }

    /**
     * Задать пустой целочисленный массив размером 8.
     * С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
     * @param variableArray массив, в котором нужно поменять значения
     * @param newElementsOfTheArray массив, откуда нужно взять элементы для изменения
     * @return возвращаем изменённый массив
     */
    public static int[] addElementsToArray (int[] variableArray, int[] newElementsOfTheArray){
        for (int i = 0; i < variableArray.length; i++){
            variableArray[i] = newElementsOfTheArray[i];
        }
        return variableArray;
    }

    /**
     * Найти максимальный элемент в массиве
     * @param array массив, который передаём для поиска макс. элемента
     */
    public static void maxInArray(int[] array){
        int maxElement = array[0];
        for (int element : array) {
            if (maxElement < element) maxElement = element;
        }
        System.out.println("Максимальный элемент: " + maxElement);
    }

    /**
     * Найти минимальный элмент в массиве
     * @param array массив, который передаём для поиска мин. элемента
     */
    public static void minInArray(int[] array){
        int maxElement = array[0];
        for (int element : array) {
            if (maxElement > element) maxElement = element;
        }
        System.out.println("Минимальный элемент: " + maxElement);
    }

    public static void changeDiagonal(int[][] array){
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
        }
        System.out.println(Arrays.deepToString(array));
    }

    /**
     * Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
     * и числа меньшие 6 умножить на 2;
     * @param array массив элементов
     * @return возвращаем изменённый массив
     */
    public static int[] changeElementsBelowSix (int[] array){
        for (int i = 0; i < array.length; i++){
            if (array[i] < 6) array[i] *= 2;
        }
        return array;
    }

    /**
     * Написать метод, в который передается не пустой одномерный целочисленный массив,
     * метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
     * Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
     * граница показана символами ||, эти символы в массив не входят.
     * leftPath - сумма левой части массива
     * position - индекс, где разделяется массив на 2 части
     * sumOfArray - сумма всего массива
     * @param array
     * @return
     */
    static int leftPath = 0;
    static int position = 0;
    static int sumOfArray = 0;

    public static boolean checkBalance(int[] array){
        sumOfArray = IntStream.of(array).sum();
        if (IntStream.of(array).sum() % 2 == 0){
            while (leftPath < (IntStream.of(array).sum() / 2)) {
                for (int i = 0; i <= array.length; i++){
                    leftPath += array[i];
                    position = i;
                    if (leftPath == (IntStream.of(array).sum() / 2)){
                        return true;
                    }
                    else if (leftPath > (IntStream.of(array).sum() / 2)){
                        return false;
                    }
                }
            }
        } else return false;
        return false;
    }
}
