package animal;

public class Pitbull extends Dog {
    private final int RUN = 600;

    public Pitbull(String name) {
        super(name);
    }

    @Override
    public boolean run(int animalRun) {
        return animalRun <= RUN;
    }
}
