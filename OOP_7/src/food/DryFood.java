package food;

public class DryFood extends Food {
    /**
     * @param title        название продукта
     * @param capacityFood обьем продукта (граммовка)
     */
    public DryFood(String title, int capacityFood) {
        super(title, capacityFood);
    }

    @Override
    public int getCapacityFood() {
        return getCapacity();
    }
}
