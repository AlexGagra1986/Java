//package ru.GeekBrains.Lesson13_Multithreading_2;
//
//import java.util.concurrent.*;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//// выполнение задач в асинхронном режиме.
//// Вообще говоря, ExecutorService автоматически предоставляет пул потоков и API для назначения ему задач.
//
//public class Test {
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
////        Executors();
////        ExecutorService executorService = Executors.newSingleThreadExecutor();//запускает только один параллельный поток передает задачи по очереди
////        for (int i = 0; i < 10; i++) {
////            final int j = i;
////            executorService.execute(()->{
////
////                try {
////                    System.out.println("Start Task"+j);
////                    Thread.sleep((long)(200+j*500*Math.random()));
////                    System.out.println("Finish Task"+j);
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
////
////            });
////        }
////        executorService.shutdown(); //завершает задачи только после тогда, пока в очереди не останется ни одной задачи
//////        executorService.shutdownNow(); //завершает задачи прямо сейчас выкидывает все что у него в очереди и вызывает метод интерапт
////        try {
////            executorService.awaitTermination(10, TimeUnit.SECONDS);  // подождать пока executorService выключиться
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//
////        ExecutorService executorService = Executors.newFixedThreadPool(4); // можно сразу обрабатывать несколько потоков
////        for (int i = 0; i < 10; i++) {
////            final int f = i;
////            executorService.execute(()->{
////
////                try {
////                    System.out.println("Start Task"+f);
////                    Thread.sleep((long)(200+f*500*Math.random()));
////                    System.out.println("Finish Task"+f);
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
////            });
////
////        }
//
////        ExecutorService executorService = Executors.newFixedThreadPool(4, new ThreadFactory() {// позволяет массово создавать объекты
////            @Override
////            public Thread newThread(Runnable r) {
////                Thread t  = new Thread(r);
////                t.setName("Executor Task");
////                return t;
////            }
////        });
////        for (int i = 0; i < 10; i++) {
////            final int f = i;
////            executorService.execute(()->{
////
////                try {
////                   System.out.println("Start Task"+f);
////                    Thread.sleep((long)(200+f*500*Math.random()));
////                    System.out.println("Finish Task"+f+""+Thread.currentThread().getName());
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
////            });
////
////        }
//
////        ExecutorService executorService = Executors.newCachedThreadPool();// Executors.newCachedThreadPool() возвращает пул потоков,
////        // если в пуле не хватает потоков, в нем будет создан новый поток.запускаю 10 потоков он и создает 10 потоков
////        for (int i = 0; i < 10; i++) {
////            final int f = i;
////            executorService.execute(()->{
////
////                try {
////                   System.out.println("Start Task"+f);
////                    Thread.sleep((long)(200+f*500*Math.random()));
////                    System.out.println("Finish Task"+f+""+Thread.currentThread().getName());
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
////            });
////
////        }
////        Future<String> future = executorService.submit(new Callable<String>() {
////            @Override
////            public String call() throws Exception {
////                return "Hello";
////            }
////        });
////
////        executorService.shutdown();
////        System.out.println(future.get());
////        System.out.println("Main Thread finish");   // //  e                                  /eexe
//
//        Lock lock = new ReentrantLock();
//
//new Thread(()->{
//    System.out.println("Before lock one");
//   try {
//       lock.lock();
//       System.out.println("Get Lock one");
//       Thread.sleep(3000);
//       System.out.println("End Lock");
//   } catch (InterruptedException e) {
//       e.printStackTrace();
//   }finally {
//       lock.unlock();
//   }
//}).start();
//
//        new Thread(()->{
//            System.out.println("Before lock two");
//            try {
//                lock.lock();
//                System.out.println("Get Lock two");
//                Thread.sleep(3000);
//                System.out.println("End Lock");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }finally {
//                lock.unlock();
//            }
//        }).start();
//
//
//
//   }
//
//}
