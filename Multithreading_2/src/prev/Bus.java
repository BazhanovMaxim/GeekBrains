package prev;

import java.util.concurrent.Semaphore;

public class Bus extends Auto{
    public Bus(String id_auto, Semaphore semaphore) {
        super(semaphore, id_auto, 40F, 7.5F);
    }
}
