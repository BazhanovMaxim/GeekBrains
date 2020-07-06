package animal;

public class Beagle extends Dog{
    private final int RUN = 400;

    public Beagle(String name) {
        super(name);
    }

    public boolean pitbullRun(int run){
        return run <= this.RUN;
    }
}
