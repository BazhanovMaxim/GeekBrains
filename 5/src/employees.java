public class employees {

    private String nameAndSurname;

    private String rang;

    private String email;

    private String number;

    private int salary;

    private int age;

    public employees(String nameAndSurname, String rang, String email, String number, int salary, int age) {
        this.nameAndSurname = nameAndSurname;
        this.rang = rang;
        this.email = email;
        this.number = number;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void getEmploy() {
        System.out.println(String.format("Name: %s, rang: %s, email %s, number %s, salary: %s, age: %s",
                nameAndSurname, rang, email, number, salary, age));
    }
}
