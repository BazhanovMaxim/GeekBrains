package prev.thirdTask;

public interface BoxHelper<T extends Box> {
    float getWeight();
    boolean compare(T box);
}
