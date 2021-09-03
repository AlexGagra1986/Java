package ru.GeekBrains.Lesson13_Multithreading_2;

import java.util.concurrent.Semaphore;

import static ru.GeekBrains.Lesson13_Multithreading_2.Main.HALF_CARS;


class Tunnel extends Stage {
    Semaphore semaphore = new Semaphore(HALF_CARS);//Семафор — это средство для синхронизации доступа к какому-то ресурсу. Его особенность заключается в том, что при создании механизма синхронизации он использует счетчик

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                semaphore.acquire();//Чтобы получить у семафора разрешение необходимо вызвать у него один из перегруженных методов acquire
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                semaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}