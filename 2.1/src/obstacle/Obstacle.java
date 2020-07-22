package obstacle;

public abstract class Obstacle {
    protected float height;
    protected float length;

    protected Obstacle(float height, float length) {
        this.height = height;
        this.length = length;
    }

    public float getHeight() {
        return height;
    }

    public float getLength() {
        return length;
    }
}
