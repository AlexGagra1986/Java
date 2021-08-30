//package ru.GeekBrains.Lesson12_Multithreading_1;
//
//
//import jdk.swing.interop.SwingInterOpUtils;
//
//import java.sql.SQLOutput;
//import java.util.concurrent.*;
////Поток — это Thread, в нём что-то запускается run
////        Оказывается, у java.lang.Runnable есть брат и зовут его java.util.concurrent.Callable и появился он на свет в Java 1.5. В чём же различия?
////        Если приглядеться к JavaDoc этого интерфейса, мы видим, что в отличие от Runnable, новый интерфейс объявляет метод call, который возвращает результат. Кроме того,
////        по умолчанию он throws Exception. То есть избавляет нас от необходимости на проверяемые исключения писать try-catch блоки
////
////        Интерфейс java.util.concurrent.Future описывает API для работы с задачами, результат которых мы планируем получить в будущем: методы получения результата, методы проверки статуса.
////
////        Для Future нас интересует его реализация java.util.concurrent.FutureTask. То есть это Task, который будет выполнен во Future. Чем эта реализация ещё интересна,
////        так это тем, что она реализует и Runnable.
////        Можно считать это своего рода адаптером старой модели работы с задачами в потоках и новой модели (новой в том смысле, что она появилась в java 1.5).
//
//public class Test {
//    public static void main(String[] args) throws InterruptedException {
////Thread.getAllStackTraces().forEach((k,v)-> System.out.println(k+ ": "+ v )); стек в потоке
////        System.out.println("Количество процессоров: "+Runtime.getRuntime().availableProcessors());// количество процессоров
////        Thread - потоки
//
//        Thread t = new Thread(()->{
//            int i = 0;
//            while (!Thread.currentThread().isInterrupted()){ ///пока поток не прерван
//
//                try {
//                    System.out.println("Tic"+ i);
//                    Thread.sleep(500);
//                    System.out.println("Tac" + i++);
//                    if(i>=10) break;
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
////                    Thread.currentThread().isInterrupted();
////                    break;
//                    return;
//                }
//
//            }
//        });
////        t.setDaemon(true);
//        t.start();
////        Thread.sleep(3000);
//        t.join(10000);// подожду пока завершиться работа портока t
//        System.out.println("Main off");
//        t.isInterrupted();
////        t.stop();
////        t.suspend();
////        t.resume();
//
//        FutureTask<String> futureTask= new FutureTask<>(new Callable<String>() { // можно возвращать поток через futureTask
//            @Override
//            public String call() throws Exception {
//                Thread.sleep(4000);
//                return "Hello from callable";
//            }
//        });
//new Thread(futureTask).start();
//        try {
//            System.out.println(futureTask.get(5, TimeUnit.SECONDS));
//        } catch (ExecutionException | TimeoutException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Hello from main!!!,Name thread is : "+ Thread.currentThread().getName()); //   ссылка на текущий поток с которого вызвали этот метод
//        Thread t1 = new MyThread("MyTheread");
//        Thread t2 = new Thread(new MyRanble());
//        Thread t3 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello from anonimus class!!!,Name thread is : "+ Thread.currentThread().getName());
//            }
//        });
//        Thread t4 = new Thread (()-> System.out.println("Hello from Lamda class!!!,Name thread is : "+ Thread.currentThread().getName()));
////  t1.run();
//        t1.start(); //Запускает новый поток и запускает метод Run
//        t2.start();
//        t3.start();
//        t4.start();
//
//        Thread.sleep(2000);
//        // t2.start();// поток нельзя запустить повторно
//    }
//    static class MyThread extends Thread{
//        public MyThread() {
//        }
//
//        public MyThread(String name){
//            super(name);
//
//        }
//
//        @Override
//        public void run() {            // метод ран является тем же что и мейн для java приложения
//            System.out.println("Hello from my thread!!!,Name thread is : "+ Thread.currentThread().getName());
//        }
//    }
//    static class MyRanble implements Runnable{
//
//    @Override
//    public void run() {
//        System.out.println("Hello from my Runable!!!,Name thread is : "+ Thread.currentThread().getName());
//    }
//}
//
//}
//// 1:36:55