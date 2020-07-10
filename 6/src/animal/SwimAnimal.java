package animal;

public abstract class SwimAnimal extends GroundAnimal {
    protected double maxSwim;

    public SwimAnimal(String name, int maxRun, double maxJump, int satiety) {
        super(name, maxRun, maxJump, satiety);
    }

    public boolean swim(int animalSwim) {
        return animalSwim <= maxSwim;
    }

    @Override
    public String name() {
        return getName();
    }
}
