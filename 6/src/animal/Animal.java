package animal;

public abstract class Animal {

    private String name;
    private int maxRun;
    private double maxJump;
    private int satiety;

    protected void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    protected Animal(String name, int maxRun, double maxJump, int satiety) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
        this.satiety = satiety;
    }

    protected abstract boolean run(int animalRun);

    protected abstract boolean satiety(int satiety);

    protected abstract boolean jump(double animalJump);

    protected abstract String name();

    protected int getSatiety() {
        return satiety;
    }

    protected String getName() {
        return name;
    }

    protected int getMaxRun() {
        return maxRun;
    }

    protected double getMaxJump() {
        return maxJump;
    }
}

