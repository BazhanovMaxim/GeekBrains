import animal.Cat;
import dishes.Dish;
import food.DryFood;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        lesson7();
        lesson7_1();
    }

    /**
     * 1. Чтобы накормить кота нужно: создать обьект класса "dishes" - посуда/миска, указав
     * название и обьем еды, который можно положить
     * 2. Создать обьект кота и указать сытость
     * 3. Создать обьект еды/пищи
     * Если в тарелку можно положить тот обьём еды, то пробуем покормить кота/кошку
     */
    public static void lesson7() {
        Cat cat1 = new Cat("Romeo");
        Dish dish = new Dish("Миска", 50);
        DryFood dryFood = new DryFood("Сухой корм Вискас", 25);
        cat1.setSatietyOfAnimals(20);
        // Если в тарелку можно положить нужный обьем еды (не больше обьема тарелки)
        if (dish.putFoodDown(dryFood.getCapacityFood())) {
            if (cat1.satiety(dish.foodIsAllowed())) {
                // Убираем еду из тарелки
                dish.removeFood(cat1.getSatiety());
            }
        }
    }

    /**
     * 5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом
     * вывести информацию о сытости котов в консоль
     */
    public static void lesson7_1() {
        Random random = new Random();
        Cat[] cats = {
                new Cat("Bars"),
                new Cat("Maxi"),
                new Cat("Poli")
        };
        Dish dish = new Dish("Миска", 50);
        DryFood dryFood = new DryFood("Сухой корм Вискас", 40);

        // Вводим сытость кошек путём рандома от 0 до 40
        for (Cat cat : cats) {
            cat.setSatietyOfAnimals(random.nextInt(40));
        }

        // Проходим по массиву кошек и если кошке хватает еды, то она ест
        if (dish.putFoodDown(dryFood.getCapacityFood())) {
            for (Cat cat : cats) {
                if (cat.satiety(dish.foodIsAllowed())) {
                    // Убираем еду из тарелки
                    dish.removeFood(cat.getSatiety());
                }
            }
        }
    }
}
