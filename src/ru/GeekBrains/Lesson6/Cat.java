package ru.GeekBrains.Lesson6;

public class Cat extends Animals {

    private final int MaxRunL = 50;
    private final int MaxSwim = 2;


    @Override
    void run(int length) {
        if((length>=0) && (length<=MaxRunL)) System.out.println("Котенок пробежал Расстояние");
        else System.out.println("Что-то пошло не так,расстояние у котенка не пройдено");
    }

    @Override
    void swim(int length) {
        System.out.println("Кошки не умеют плавать");
    }
}
