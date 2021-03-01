package prev;

import java.util.concurrent.Semaphore;

public class Truck extends Auto{
    public Truck( String id_auto, Semaphore semaphore) {
        super(semaphore, id_auto, 60F, 15F);
    }
}
