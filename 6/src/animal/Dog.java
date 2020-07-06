package animal;

public class Dog extends Animal {

    public Dog(String name) {
        super(name, 500, 0.5, 10);
    }

    public String dogName() {
        return getName();
    }

    public boolean dogRun(int run) {
        return run <= getRun();
    }

    public boolean dogJump(double jump) {
        return jump <= getJump();
    }

    public boolean dogSwim(int swim) {
        return swim <= getSwim();
    }
}
