package prev;

import java.util.concurrent.Semaphore;

public abstract class Auto implements Runnable {
    protected final Semaphore SEMAPHORE;
    protected final String ID_AUTO;
    protected float capacity;
    protected float fullCapacity;
    protected float consumption;

    public Auto(Semaphore semaphore, String id_auto, float capacity, float consumption) {
        this.SEMAPHORE = semaphore;
        this.ID_AUTO = id_auto;
        this.capacity = capacity;
        this.fullCapacity = capacity;
        this.consumption = consumption;
    }

    public String getID_AUTO() {
        return ID_AUTO;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.printf("Auto[%s] поехала: \n", getID_AUTO());
            while (capacity >= 0) {
                try {
                    Thread.sleep(3000);
                    capacity -= consumption;
                    if (capacity < 0){
                        break;
                    }
                    System.out.printf("Обьем бака в машине[%s]: [%s]\n", ID_AUTO, capacity);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                SEMAPHORE.acquire();
                new FuelStation(this).refuel(fullCapacity);
                SEMAPHORE.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
