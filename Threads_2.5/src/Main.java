import prev.CalculationArray;

import java.util.Arrays;

public class Main {

    static final int size = 10000000;
    static final int numberOfCells = size / 2;
    static float[] array = new float[size];

    static float[] firstThread = new float[numberOfCells];
    static float[] secondThread = new float[numberOfCells];

    public static void main(String[] args) {
        firstMethod();
        secondMethod();
    }

    /**
     * Первый метод
     */
    public static void firstMethod() {
        fillArray(array);
        new CalculationArray(array).run();
    }

    /**
     * Второй метод
     */
    public static void secondMethod() {
        long startTime = System.currentTimeMillis();
        fillArray(array);
        arrayCopy(array, 0, firstThread, 0, numberOfCells);
        arrayCopy(array, 0, secondThread, 0, numberOfCells);

        Thread thread = new Thread(new CalculationArray(firstThread));
        Thread second = new Thread(new CalculationArray(secondThread));
        thread.start();
        second.start();

        try {
            thread.join();
            second.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        arrayCopy(firstThread, 0, array, 0, numberOfCells);
        arrayCopy(secondThread, 0, array, numberOfCells, numberOfCells);
        System.out.printf("Время просчётов массивов и потоков 2-о метода: %s", System.currentTimeMillis() - startTime);
    }

    /**
     * Заполнение массива едицами
     *
     * @param array массив, который нужно заполнить
     */
    public static void fillArray(float[] array) {
        Arrays.fill(array, 1);
    }

    /**
     * Копирование массива
     *
     * @param array            массив-источник
     * @param startPosition    откуда начинаем брать данные из массива-источника
     * @param arrayDestination массив-назначение
     * @param startDArray      откуда начинаем записывать данные в массив-назначение
     * @param count            сколько ячеек копируем
     */
    public static void arrayCopy(float[] array, int startPosition, float[] arrayDestination, int startDArray, int count) {
        System.arraycopy(array, startPosition, arrayDestination, startDArray, count);
    }


}
