import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Random random;
    private static Scanner scanner;

    public static void main(String[] args) {
        doFirstTask();
    }

    /**
     * Написать программу, которая загадывает случайное число от 0 до 9,
     * и пользователю дается 3 попытки угадать это число. При каждой попытке компьютер
     * должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
     * После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
     */
    public static void doFirstTask (){
        while (true){
            random = new Random();
            scanner = new Scanner(System.in);
            int randomNumber = random.nextInt(10);
            int counter = 1;
            for (int i = 0; i < 3; i++){
                System.out.println("Введите число: ");
                scanner = new Scanner(System.in);
                int userNumber = scanner.nextInt();
                if (userNumber < randomNumber){
                    System.out.printf("Число меньше загаданного, осталось попыток: %d\n", 3 - counter);
                    counter++;
                }
                else if (userNumber > randomNumber){
                    System.out.printf("Число больше загаданного, осталось попыток: %d\n", 3 - counter);
                    counter++;
                }
                else if (counter == 3){
                    System.out.println("Вы проиграли, попыток не осталось");
                }
                else {
                    System.out.println("Вы угадали число");
                    break;
                }
            }
            System.out.println("Сыграть ещё раз? ");
            Scanner newScanner = new Scanner(System.in);
            if (newScanner.nextInt() == 0) break;
        }
    }
}
