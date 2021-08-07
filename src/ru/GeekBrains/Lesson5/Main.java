package ru.GeekBrains.Lesson5;

public class Main {
    public static void main(String[] args) {

        Employee[] persAr = new Employee[5];
        persAr[0] = new Employee("Maksim Ivanov", "Engener", "ssss@.ru", 5555, 50, 24);
        persAr[1] = new Employee("Pavel Sokolov", "Engener", "ssss@.ru", 1111, 11, 45);
        persAr[2] = new Employee("Ilia Mokrousov", "SuplayManedger", "ssss@.ru", 55255, 24, 20);
        persAr[3] = new Employee("Sergei Ivanov", "Engener", "ssss@.ru", 555225, 65, 65);
        persAr[4] = new Employee("Artem Ivanov", "Director", "ssss@.ru", 3333, 50, 40);


        for (Employee em : persAr) {
            if (em.getAge() > 40) {
                System.out.println(em);
            }
        }

    }
}
