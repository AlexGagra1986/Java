package ru.GeekBrains.Lesson6.AdvancedOop;

public class Dog extends Animals{

    private final int MaxRunL = 100;
    private final int MaxSwim = 50;



    @Override
    void run(int length) {
        if((length>=0) && (length<=MaxRunL)) System.out.println("Собака пробежала Расстояние");
        else System.out.println("Что-то пошло не так,расстояние не пройдено");
    }

    @Override
    void swim(int length) {
        if((length>=0) && (length<=MaxSwim)) System.out.println("Собака  Проплыл");
        else System.out.println("Что-то пошло не так,Собака не доплыл");
    }


}
