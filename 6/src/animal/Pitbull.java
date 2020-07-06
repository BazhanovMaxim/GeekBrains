package animal;

public class Pitbull extends Dog {
    private final int RUN = 600;

    public Pitbull(String name) {
        super(name);
    }

    public boolean pitbullRun(int run){
        return run <= this.RUN;
    }
}
