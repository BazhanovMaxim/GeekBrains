package food;

public class LiquidFood extends Food {
    /**
     * @param title        название продукта
     * @param capacityFood обьем продукта (граммовка)
     */
    public LiquidFood(String title, int capacityFood) {
        super(title, capacityFood);
    }

    @Override
    public int getCapacityFood() {
        return getCapacity();
    }
}
