package dishes;

public class Dish extends Dishes {

    public Dish(String nameDishes, int capacity) {
        super(nameDishes, capacity, 0);
    }

    /**
     * Добавление еды в тарелку/миску
     *
     * @param capacityOfFood обьём еды, если не превышает, положить еду можно
     * @return false/true
     */
    @Override
    public boolean putFoodDown(int capacityOfFood) {
        if (capacityOfFood > getCapacity()) {
            System.out.println(String.format("Слишком много еды вы положили в %s. Максимальный обьем %s = %s, " +
                    "а пытаетесь положить = %s", getNameDishes(), getNameDishes(), getCapacity(), capacityOfFood));
            return false;
        } else {
            setFoodIsAllowed(capacityOfFood);
            System.out.println(String.format("Вы положили в %s еду обьёмом %s", getNameDishes(), capacityOfFood));
            return true;
        }
    }

    @Override
    public int foodIsAllowed() {
        return getFoodIsAllowed();
    }

    @Override
    public void removeFood(int capacityOfFood) {
        setFoodIsAllowed(foodIsAllowed() - capacityOfFood);
        System.out.println(String.format("В %s осталось %s обьёма еды", getNameDishes(), foodIsAllowed()));
    }
}
