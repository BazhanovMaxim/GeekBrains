import prev.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        firstTask();
        secondTask();
    }

    public static void firstTask() {
        FruitList fruitList = new Fruit(Arrays.asList("apple", "avocado", "apricot", "banana", "date",
                "fig", "grapefruit", "grapes", "mango", "pear",  "avocado", "apricot", "banana", "date",
                "avocado", "apricot"));
        fruitList.findUnique();
        fruitList.repeatWords();
    }

    public static void secondTask(){
        TelephoneCatalog telephoneCatalog = new TelephoneCatalog();

        Human[] persons = {
                new Human("Bazhanov"),
                new Human("Bazhanov"),
                new Human("Kitova"),
                new Human("Astafiev")
        };

        HumanTelephones[] humanTelephones = {
                new HumanTelephones(89687221548L),
                new HumanTelephones(89687221549L),
                new HumanTelephones(89687220000L),
                new HumanTelephones(89680001100L),
        };

        for (int i = 0; i < persons.length; i++) {
            telephoneCatalog.add(humanTelephones[i], persons[i]);
        }

        telephoneCatalog.get("Bazhanov");
        telephoneCatalog.print();
    }
}
