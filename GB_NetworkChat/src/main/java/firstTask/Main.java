package firstTask;

public class Main {
    private static final Main main = new Main();
    private char currentChar = 'A';

    public static void main(String[] args) {
        Thread thread1 = new Thread(main::printA);
        Thread thread2 = new Thread(main::printB);
        Thread thread3 = new Thread(main::printC);
        thread1.start();
        thread2.start();
        thread3.start();
    }

    /**
     * Запускается первый поток
     * synchronized - забирает обьект и работает с ним, не даёт другим потокам что-то делать с ним
     * Идёт в цикл for, в цикл while не заходит, т.к. currentChar = A
     * Печатает символ и меняет символ в currentChar, дальше отдаём обьект и попадет в цикл while, где ждём:
     * 1. Пока currentChar не станет А
     * 2. Пока другие потоки не освободят обьект main
     */
    public synchronized void printA() {
        try {
            for (int i = 0; i < 5; i++) {
                while (currentChar != 'A') {
                    main.wait();
                }
                System.out.print('A');
                currentChar = 'B';
                main.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void printB() {
        try {
            for (int i = 0; i < 5; i++) {
                while (currentChar != 'B') {
                    main.wait();
                }
                System.out.print('B');
                currentChar = 'C';
                main.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void printC() {
        try {
            for (int i = 0; i < 5; i++) {
                while (currentChar != 'C') {
                    main.wait();
                }
                System.out.print('C');
                currentChar = 'A';
                main.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}