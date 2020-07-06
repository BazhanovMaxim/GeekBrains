package animal;

public class Dog extends Animal {

    public Dog(String name) {
        super(name, 500, 0.5, 10);
    }

    @Override
    public boolean run(int animalRun) {
        return animalRun <= getRun();
    }

    @Override
    public boolean jump(int animalJump) {
        return animalJump <= getJump();
    }

    @Override
    public boolean swim(int animalSwim) {
        return false;
    }

    @Override
    public String name() {
        return getName();
    }
}