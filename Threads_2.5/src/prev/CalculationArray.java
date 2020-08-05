package prev;

public class CalculationArray implements Runnable {
    private final float[] array;

    public CalculationArray(float[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        changeArray(array);
    }

    /**
     * Изменение массива по формуле
     * @param array массив-источник
     */
    private synchronized void changeArray(float[] array) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5f) * Math.cos(0.2f + i / 5f) * Math.cos(0.4f + i / 2f));
        }
        System.out.printf("Время заполнения массива потоком: %s = %s\n", Thread.currentThread().getName(), System.currentTimeMillis() - start);
    }
}
