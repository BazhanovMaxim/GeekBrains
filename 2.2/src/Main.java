import exceptions.MyArrayDataException;
import exceptions.MySizeArrayException;

public class Main {
    public static void main(String[] args) {
        final int MAX_LINE = 4;
        final int MAX_COLUMN = 4;

        String[] testArray = new String[]{"1", "2", "3", "4",
                "4", "3", "2", "1",
                "10", "11", "20", "22",
                "1", "3", "11", "10"};

        System.out.println(sumOfArray(fillArray(MAX_LINE, MAX_COLUMN, testArray)));
    }

    /**
     * Заполнение двумерного массива
     *
     * @param MAX_LINE        кол-во строк
     * @param MAX_COLUMN      кол-во столбцов
     * @param elementsOfArray массив элементов для заполнения двумерного массива
     * @return двумерный массив. matrix
     */
    public static String[][] fillArray(int MAX_LINE, int MAX_COLUMN, String[] elementsOfArray) {
        String[][] matrix = new String[MAX_LINE][MAX_COLUMN];
        int x = 0;
        try {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = elementsOfArray[x];
                    x = x + 1;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            try {
                throw new MySizeArrayException(String.format("Элементов мало для заполнения массива.\n" +
                        "Нужно добавить: %s элемент\n", MAX_COLUMN * MAX_LINE - Integer.parseInt(e.getMessage())) + e);
            } catch (MySizeArrayException mySizeArrayException) {
                mySizeArrayException.printStackTrace();
            }
        }
        return matrix;
    }

    /**
     * Сумма массива
     *
     * @param array массив, который нужно просуммировать
     * @return сумму массива
     */
    public static int sumOfArray(String[][] array) {
        int sumOfArray = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                try {
                    sumOfArray += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    try {
                        throw new MyArrayDataException(String.format("Неверный элемент массива, строка: %s, столбец: %s\n", i + 1, j + 1) + e);
                    } catch (MyArrayDataException myArrayDataException) {
                        myArrayDataException.printStackTrace();
                    }
                }
            }
        }

        return sumOfArray;
    }

    /**
     * Вывод массива
     *
     * @param array двумерный массив для вывода в консоль
     */
    public static void outputAnArray(String[][] array) {
        System.out.println("======= Вывод массива =======");
        for (String[] aMatrix : array) {
            for (String anAMatrix : aMatrix) {
                System.out.print(anAMatrix + "\t");
            }
            System.out.println();
        }
    }


}
