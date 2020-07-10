package food;

public abstract class Food {
    private String title;
    private int capacityFood;

    /**
     * @param title        название продукта
     * @param capacityFood обьем продукта (граммовка)
     */
    protected Food(String title, int capacityFood) {
        this.title = title;
        this.capacityFood = capacityFood;
    }

    protected abstract int getCapacityFood();

    protected int getCapacity() {
        return this.capacityFood;
    }
}
