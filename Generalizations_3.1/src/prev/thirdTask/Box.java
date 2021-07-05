package prev.thirdTask;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> implements BoxHelper {
    private List<T> fruitBox;

    private String nameOfBox;

    public Box(String nameOfBox) {
        this.fruitBox = new ArrayList<>();
        this.nameOfBox = nameOfBox;
    }

    public String getNameOfBox() {
        return nameOfBox;
    }

    public void addFruit(T fruit) {
        fruitBox.add(fruit);
    }

    public void addAllFruitsAnotherBox(Box<T> newBox) {
        for (T fruit : fruitBox) newBox.addFruit(fruit);
        clearFruitBox();
    }

    @Override
    public float getWeight() {
        float weight = 0;
        for (T fruit : fruitBox) weight += fruit.getWeight();
        return weight;
    }

    @Override
    public boolean compare(Box box) {
        return getWeight() > box.getWeight();
    }

    private void clearFruitBox() {
        fruitBox.clear();
    }
}
