package prev;

import java.util.concurrent.Semaphore;

public class Car extends Auto {
    public Car(String id_auto, Semaphore semaphore) {
        super(semaphore, id_auto, 20F, 2.5F);
    }
}
