package ru.GeekBrains.Lesson5;

public class Employee {
    private String FIO;
    private String position;
    private String email;
    private int telephone;
    private int salary;
    private int age;

    public Employee(String FIO, String position, String email, int telephone, int salary, int age) {
        this.FIO = FIO;
        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
    }


    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "FIO='" + FIO + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", telephone=" + telephone +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
