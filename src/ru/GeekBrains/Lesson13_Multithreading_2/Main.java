package ru.GeekBrains.Lesson13_Multithreading_2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static final int CARS_COUNT = 4;
    public static final int HALF_CARS= CARS_COUNT/2;
    public static final int COUNTER = 5;
    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        CyclicBarrier cyclicBarrier = new CyclicBarrier(COUNTER); //CyclicBarrier - это метод синхронизации, который является частью java.util.concurrent пакет и доступен с Java5. CyclicBarrier ждет всех темы чтобы завершить его выполнение, не дойдя до точки.
        CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT);//CountDownLatch. CountDown на английском — это отсчёт, а Latch — задвижка или защёлка. То есть если переводить, то это защёлка с отсчётом. Тут нам понадобится соответствующий импорт класса java.util.concurrent.CountDownLatch.

        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 50),cyclicBarrier,countDownLatch);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        try {
            cyclicBarrier.await();//await — то есть ожидать, пока значение счётчика не станет ноль.
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            cyclicBarrier.await();
            cyclicBarrier.await();
        } catch (BrokenBarrierException    e) {
            e.printStackTrace();
        }catch(InterruptedException e ){
            e.printStackTrace();
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");

    }
}




