package animal;

public class Beagle extends Dog{
    private final int RUN = 400;

    public Beagle(String name) {
        super(name);
    }

    @Override
    public boolean run(int animalRun) {
        return animalRun <= RUN;
    }

    @Override
    public String name() {
        return super.name();
    }
}
