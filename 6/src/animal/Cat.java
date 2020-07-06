package animal;

public class Cat extends Animal {

    public Cat(String name) {
        super(name, 200, 2, 0);
    }

    public String catName() {
        return getName();
    }

    public boolean catRun(int run) { return run <= getRun();}

    public boolean catJump(double jump) {
        return jump <= getJump();
    }

}
