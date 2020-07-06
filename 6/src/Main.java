import animal.Beagle;
import animal.Cat;
import animal.Dog;
import animal.Pitbull;

public class Main {

    public static void main(String[] args) {

        Dog dog1 = new Dog("Ram");
        Cat cat1 = new Cat("Barsik");
        Pitbull pitbull = new Pitbull("Marabi");
        Beagle beagle = new Beagle("Baron");

        System.out.println(String.format("Name dog: %s, run: %s, jump: %s, swim: %s", dog1.name(),
                dog1.run(450), dog1.jump(1), dog1.swim(12)));

        System.out.println(String.format("Name cat: %s, run: %s, jump: %s", cat1.name(),
                cat1.run(2), cat1.jump(1)));

        System.out.println(String.format("Name dog: %s, run: %s", pitbull.name(), pitbull.run(601)));

        System.out.println(String.format("Name dog: %s, run: %s", beagle.name(), beagle.run(450)));

    }
}
