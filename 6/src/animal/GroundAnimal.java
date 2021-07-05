package animal;

public abstract class GroundAnimal extends Animal {

    public GroundAnimal(String name, int maxRun, double maxJump, int satiety) {
        super(name, maxRun, maxJump, satiety);
    }

    @Override
    public boolean run(int animalRun) {
        return animalRun <= getMaxRun();
    }

    @Override
    public boolean jump(double animalJump) {
        return animalJump <= getMaxJump();
    }

    @Override
    public String name() {
        return getName();
    }

    @Override
    public int getSatiety() {
        return super.getSatiety();
    }

    @Override
    public boolean satiety(int satiety) {
        if (satiety < getSatiety()) {
            System.out.println(String.format("%s не стал есть, еды мало.", getName()));
            return false;
        } else {
            System.out.println(String.format("%s наелся и спит", getName()));
            return true;
        }
    }

    public void setSatietyOfAnimals(int satiety) {
        setSatiety(satiety);
    }
}
