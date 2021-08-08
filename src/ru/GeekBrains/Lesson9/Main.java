package ru.GeekBrains.Lesson9;

public class Main {
    private static final int SIZE = 4 ;// cоздаю статическое поле фиксированной длины

    public static void main(String[] args) {

        String[][] arr = new String[][]{{"1", "2", "1", "4"}, {"2", "2", "2", "7","4"}, {"q", "2", "2", "2"}, {"2", "2", "2", "2"}};
        try {                          //помещаю в конструкцию try мой метод для отлова исключения
            try {
                int result = method(arr);   // создаю переменную int и прсваиваю ей значения метода с входными данными
                System.out.println(result);  // вывожу результат в консоль
            } catch (MyArraySizeException e) {   // если размер массива превышен срабатывает исключение по размеру
                System.out.println("Размер массива превышен!"); // вывожу в консоль
            }
        }
        catch (MyArrayDataException e) {    // перехватываю исключение с не корректным значением массива
            System.out.println("Неправильное значение массива!"); // вывожу результат в консоль
            System.out.println("Ошибка в ячейке: " + e.i + "x" + e.j);// выявляю в какой ячейке ошибка
        }

    }


    public static int method(String[][] arr) throws MyArraySizeException, MyArrayDataException { // использую в сигнатуре метода мои созданые исключения
        int count = 0;                 // создаю счетчик
        if (arr.length != SIZE) {    // условие если длинна массива превыышает фиксированное значение тогда срабатывает исключение
            throw new MyArraySizeException(); // если исключительная ситуация то сгенерировать исключение
        }
        for (int i = 0; i < arr.length; i++) {  // бегу i элементу массива  от 0 до конечной его длинны
            if (arr[i].length != SIZE) {       // условие при пробежке по массиву , если размерность превышает положенную то срабатывает исключение и если меньше то тоже срабатывает
                throw new MyArraySizeException(); // и генерируеться исключение при срабатывании условия выше
            }
            for (int j = 0; j < arr[i].length; j++) { // бегу по j элементу массива от 0 до конечной длины i элемента
                try {
                    count = count + Integer.parseInt(arr[i][j]);  // ложу в наш счетчик каждый элемент и преобразую его в int
                }
                catch (NumberFormatException e) { // если преобразование не удалось то выкидывается исключение по не корректному элементу массива, например буква
                    throw new MyArrayDataException(i, j);  // в какой конкретно ячейке преобразование не удалось
                }
            }

        }
       return count;
        }

        }
