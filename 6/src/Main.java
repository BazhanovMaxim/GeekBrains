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

        System.out.println(String.format("Name dog: %s, run: %s, jump: %s, swim: %s", dog1.dogName(),
                dog1.dogRun(450), dog1.dogJump(1), dog1.dogSwim(12)));

        System.out.println(String.format("Name cat: %s, run: %s, jump: %s", cat1.catName(),
                cat1.catRun(2), cat1.catJump(1)));

        System.out.println(String.format("Name dog: %s, run: %s", pitbull.dogName(), pitbull.pitbullRun(450)));

        System.out.println(String.format("Name dog: %s, run: %s", beagle.dogName(), beagle.pitbullRun(450)));

    }
}
