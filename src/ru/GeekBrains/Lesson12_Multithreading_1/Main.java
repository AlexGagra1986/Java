package ru.GeekBrains.Lesson12_Multithreading_1;

public class Main {
    private static final int SIZE = 10000000; // создаю статическую константу размерности
    private static final int HALF = SIZE / 2;// создаю статическую константу равную половине обьема размерности

     public float[] Calc(float[] arr) { // метод подсчета
        for (int i = 0; i < arr.length; i++) // бегу по массиву и для каждой ячейки ставлю новое значение по формуле
            arr[i] = (float) (arr[i] * Math.sin(0.2f + arr[i] / 5) * Math.cos(0.2f + arr[i] / 5) * Math.cos(0.4f + arr[i] / 2));
        return arr; // возвращаю значение
    }
    public void Th1() { // первый поток
        float[] arr = new float[SIZE]; // массив с плавающей точкой размерностью size
        for (int i = 0; i < arr.length; i++) arr[i] = 1.0f; // заполняю массив единицами
        long t1 = System.currentTimeMillis(); // создаю переменную со значением времяни выполнения
        Calc(arr);//Подставляю массив заполненый единицами в метод для вычисления по формуле
        System.out.println("Первый поток конечное время: " + (System.currentTimeMillis() - t1 + " ms"));// вывожу время выполнения модификаций
    }
    public void Th2() {
        float[] arr = new float[SIZE]; //создаю массив float размерностью Size
        float[] arr1 = new float[HALF];// разбиваю массив на 2 половины
        float[] arr2 = new float[HALF];
        for (int i = 0; i < arr.length; i++)
            arr[i] = 1.0f; // заполняю массив единицами

        long t2 = System.currentTimeMillis();// создаю переменную со значением времяни выполнения
        System.arraycopy(arr, 0, arr1, 0, HALF);// разбиваю массив на 2 половины заполненый
        System.arraycopy(arr, HALF, arr2, 0, HALF);// разбиваю массив на 2 половины заполненый

        new Thread() { // создаю поток 1
            public void run() { // главный метод для выполнения аналог psvm
                float[] ar1 = Calc(arr1); // прогоняю наш массив через формулу в методе Calc первую часть
                System.arraycopy(ar1, 0, arr1, 0, ar1.length);//  копирую преобразованные данные в arr1
            }
        }.start(); // запускаю поток 1 методом start

        new Thread() { // создаю поток 2
            public void run() {
                float[] ar2 = Calc(arr2); // прогоняю наш массив через формулу в методе Calc вторую часть
                System.arraycopy(ar2, 0, arr2, 0, ar2.length); // копирую преобразованные данные в arr2
            }
        }.start();// запускаю поток 2 методом start
        System.arraycopy(arr1, 0, arr, 0, HALF); // копирую первую часть массива в arr
        System.arraycopy(arr2, 0, arr, HALF, HALF);// копирую вторую часть массива в arr
        System.out.println("Второй поток,конечное время: " + (System.currentTimeMillis() - t2 + " ms")); // вывожу время выполнения модификаций
    }

        public static void main (String s[]){//начало 33 минута
            Main Main = new Main(); // Создаю экземпляр main
            Main.Th1(); //запуск первого метода
            Main.Th2(); //запуск второго метода

        }
    }

