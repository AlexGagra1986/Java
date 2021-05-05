package ru.GeekBrains.OOP_Begin.Employee;

public class Employee {
    String FIO;
    String position;
    String email;
    int telephone;
    int salary;
    int age;

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
