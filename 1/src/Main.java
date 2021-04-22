public class Main {

    public static void main(String[] args) {

        byte one = 101;
        int number = 2147483641;
        long l = 101L;
        float fl = 11.6F;
        double dbl = 3.14;
        char c = 'c';
        boolean yes = true;
        boolean no = false;
        String str = "Hello, world!";

        System.out.println(thirdTask(10, 2, 4, 2));

        System.out.println(fourthTask(5, 10));

        System.out.println(fifthTask(5));

        System.out.println(sixTask(-100));

        sevenTask("Bazhanov Maxim");

        System.out.println(leapYear(104));

    }


    /**
     * Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
     * где a, b, c, d – входные параметры этого метода;
    * */
    public static int thirdTask(int a, int b, int c, int d){
        return a * (b + (c / d));
    }


    /**
     * Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит
     * в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
     */
    public static boolean fourthTask(int firstNumber, int secondNumber){
        return (firstNumber + secondNumber) > 10 && (firstNumber + secondNumber) < 21;
    }

    /**
     * Написать метод, которому в качестве параметра передается целое число,
     * метод должен напечатать в консоль положительное ли число передали, или отрицательное;
     * Замечание: ноль считаем положительным числом.
     */
    public static String fifthTask(int number){
        if (number > -1) return "Положительное";
        else return "Отрицательное";
    }

    /**
     * Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true,
     * если число отрицательное;
     */
    public static boolean sixTask(int number){
        return (number < 0);
    }

    /**
     * Написать метод, которому в качестве параметра передается строка, обозначающая имя,
     * метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
     */
    public static void sevenTask(String userName){
        final String greetingUsers = "Привет, ";
        System.out.println(greetingUsers + userName + "!");
    }

    /**
     * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
     * Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
     */
    public static String leapYear(int year){
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            return "Високосный";
        } else return "Не високосный";
    }
}
