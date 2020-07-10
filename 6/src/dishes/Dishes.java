package dishes;

public abstract class Dishes {
    private String nameDishes;
    private int capacity;
    private int foodIsAllowed;

    public Dishes(String nameDishes, int capacity, int foodIsAllowed) {
        this.nameDishes = nameDishes;
        this.capacity = capacity;
        this.foodIsAllowed = foodIsAllowed;
    }

    protected abstract int foodIsAllowed();

    protected abstract boolean putFoodDown(int capacityOfFood);

    protected abstract void removeFood(int capacityOfFood);

    protected int getFoodIsAllowed() {
        return foodIsAllowed;
    }

    protected String getNameDishes() {
        return nameDishes;
    }

    protected int getCapacity() {
        return capacity;
    }

    protected void setFoodIsAllowed(int foodIsAllowed) {
        this.foodIsAllowed = foodIsAllowed;
    }
}
