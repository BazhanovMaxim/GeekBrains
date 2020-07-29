package prev;

import java.util.*;

public class Fruit implements FruitList {
    private List<String> fruits;

    public Fruit(List<String> fruits) {
        this.fruits = new ArrayList<>(fruits);
    }

    @Override
    public void add(Object nameOfFruit) {
        fruits.add(String.valueOf(nameOfFruit));
    }

    @Override
    public boolean remove(Object nameOfFruit) {
        return fruits.remove(String.valueOf(nameOfFruit));
    }

    @Override
    public void findUnique() {
        // System.out.println(String.format("Unique fruits: %s", new TreeSet<>(fruits)));
        List<String> uniqueFruit = new ArrayList<>();
        for (String i : fruits){
            int count = 0;
            for (String fruit : fruits){
                if (i.equals(fruit)) count++;
            }
            if (count == 1) uniqueFruit.add(i);
        }
        System.out.println(String.format("Unique fruits: %s", uniqueFruit));
    }

    @Override
    public void repeatWords() {
        Map<String, Integer> mapOfWord = new HashMap<>();
        for (String i : fruits) {
            int count = 0;
            for (String word : fruits) {
                if (i.equals(word)) count++;
            }
            mapOfWord.put(i, count);
        }

        // Неотсортированный вывод по значению
        for (Map.Entry<String, Integer> map : mapOfWord.entrySet()){
            System.out.println(String.format("Fruit: %s, count: %s", map.getKey(), map.getValue()));
        }

        // Отсортированный вывод по значению
        //mapOfWord.entrySet().stream()
        //        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
        //        .forEach(System.out::println);
    }
}
