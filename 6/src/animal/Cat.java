package animal;

public class Cat extends Animal {

    public Cat(String name) {
        super(name, 200, 2, 0);
    }

    @Override
    public boolean run( int animalRun) {
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
