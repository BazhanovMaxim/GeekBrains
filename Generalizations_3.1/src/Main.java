import prev.firstSecondTasks.ArrayToList;
import prev.firstSecondTasks.ChangeToElements;
import prev.thirdTask.Apple;
import prev.thirdTask.Box;
import prev.thirdTask.Orange;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        changeTwoElements();
        arrToArrayList();
        thirdTask();
    }

    /**
     * 1. Написать метод, который меняет два элемента массива местами.
     * (массив может быть любого ссылочного типа);
     */
    public static void changeTwoElements() {
        String[] array = {"-1-", "-2-", "-3-", "-4-", "-5-"};
        try {
            System.out.println(Arrays.toString(new ChangeToElements<>(array).changeElements(1, 10)));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.printf("Индекс элемента за пределами массива(array(%s), index(%s))\n", array.length, e.getMessage());
        }
    }

    /**
     * 2. Написать метод, который преобразует массив в ArrayList;
     * <?> - незвестное значение типа массива[array]
     */
    public static void arrToArrayList() {
        String[] array = {"Hello", "World"};
        ArrayToList<?> test = new ArrayToList<>(array);
        test.getList();
    }

    /**
     * 3. Большая задача:
     * a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
     * b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
     * c. Для хранения фруктов внутри коробки можете использовать ArrayList;
     * d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
     * e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
     * f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
     * g. Не забываем про метод добавления фрукта в коробку.
     */
    public static void thirdTask() {
        Box<Apple> appleBox = new Box<>("AppleBox");
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());

        Box<Apple> appleBox_2 = new Box<>("newAppleBox");
        appleBox_2.addFruit(new Apple());
        appleBox_2.addAllFruitsAnotherBox(appleBox);
        System.out.printf("Вес[%s] = %s\n", appleBox_2.getNameOfBox(), appleBox_2.getWeight());

        Box<Orange> orangeBox = new Box<>("OrangeBox");
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        appleBox.compare(orangeBox);
    }
}
