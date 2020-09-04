import prev.Auto;
import prev.Bus;
import prev.Car;
import prev.Truck;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3, true);
        Auto[] auto = {new Car("BMW X5", semaphore),
                new Car("Mercedes-Benz X166", semaphore),
                new Car("Lada Kalina", semaphore),
                new Car("Lolvo XC90 II", semaphore),
                new Bus("School Bus", semaphore),
                new Bus("Medic bus", semaphore),
                new Bus("MAN Lion's City", semaphore),
                new Truck("KAMAS", semaphore),
                new Truck("URAL", semaphore),
                new Truck("NEFAZ", semaphore)};

        for (Auto auto1 : auto) new Thread(auto1).start();
    }
}


