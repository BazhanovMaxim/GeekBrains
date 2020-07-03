public class main {

    public static void main(String[] args) {
        createEmployees();
        getEmployeesOlder40Years();
    }

    /**
     * Задания 1, 2, 3
     * Вывод в консоль информацию об объектах
     */
    public static void createEmployees(){
        employees employees1 = new employees("Maxim Bazhanov", "Software tester",
                "bazhanov.maksim@list.ru",
                "89687221548", 100000, 22);

        employees employees2 = new employees("Vlad Mikhailov", "Product manager",
                "bazhanov.maksim@list.ru",
                "89687221548", 100000, 40);

        employees employees3 = new employees("Egor Melnikov", "Developer",
                "bazhanov.maksim@list.ru",
                "89687221548", 100000, 40);

        employees1.getEmploy();
        employees2.getEmploy();
    }

    /**
     * Задания 4, 5
     * Вывод в консоль информацию о сотрудниках старше 40 лет
     */
    public static void getEmployeesOlder40Years(){
        employees[] persArray = new employees[5];
        persArray[0] = new employees("Sergey Dmitrievich", "Engineer", "ivivan@mailbox.com",
                "892312312", 30000, 30);
        persArray[1] = new employees("Anton Maslov", "Software tester", "ivivan@mailbox.com",
                "892312312", 15000, 40);
        persArray[2] = new employees("Ivan Morozov", "Security guard", "ivivan@mailbox.com",
                "892312312", 60000, 45);
        persArray[3] = new employees("Daria Rykova", "Game designer", "ivivan@mailbox.com",
                "892312312", 75000, 41);
        persArray[4] = new employees("Kristina Poghosyan", "Game developer", "ivivan@mailbox.com",
                "892312312", 25000, 49);

        for (employees employees : persArray) {
            if (employees.getAge() > 40) employees.getEmploy();
        }
    }

}
