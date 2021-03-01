package prev;

public class FuelStation {
    private final Auto auto;

    public FuelStation(Auto auto) {
        this.auto = auto;
    }

    /**
     * Пополнение топлива в баке авто
     *
     * @param capacity объем, который нужно для авто для полного пополнения
     * @throws InterruptedException исключение ожидания, прерывания потока
     */
    public void refuel(float capacity) throws InterruptedException {
        System.out.printf("Auto[%s] заправляется\n", auto.getID_AUTO());
        Thread.sleep(5000);
        auto.setCapacity(capacity);
        System.out.printf("Auto[%s] заправилось, обьем бака: [%s]\n", auto.getID_AUTO(), auto.getCapacity());
    }
}
