package animal;

public class Animal {

    private String name;
    private int run;
    private double jump;
    private int swim;

    public Animal(String name, int run, double jump, int swim) {
        this.name = name;
        this.run = run;
        this.jump = jump;
        this.swim = swim;
    }

    protected String getName() {
        return name;
    }

    protected int getRun() {
        return run;
    }

    protected double getJump() {
        return jump;
    }

    protected int getSwim() {
        return swim;
    }
}
