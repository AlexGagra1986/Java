//package ru.GeekBrains.Lesson10_Collection.Test;
//
//import javax.swing.text.html.HTMLDocument;
//import java.util.ArrayList;
//import java.util.Iterator;
////import java.util.List;
////import java.util.ListIterator;
////import java.util.function.Consumer;
////
////// любые коллекции работают только со ссылочными типами данных
////public class ArrayList {
////
////
////
////
////    public static void main(String[] args) {
////        List list =new ArrayList<>(); //Raw use
////        List list <String> = new ArrayList<>(); // строго типизированный список
//        list.add("January");//Добавление элемента в Коллекцию(Массив)
//        list.add("Febryary");
//        list.add("March");
//        list.add("March");
//        list.add(0, "April");// добавление элемента в определенное место списка
////        ((ArrayList) list).trimToSize();// создает массив с четко по количеству элементов
////        list.clear(); // очищает список
////        list.sort((s1, s2) -> s1.length() - s2.length()); //сортировка через лямда выражение
////        list.sort(new Comparator<String>() {
////            @Override
////            public int compare(String o1, String o2) { // сравнивает 2 обьекта
////                return o1.length() - o2.length(); // сортировка по длине строк одно из многих условий.больший будет считаться элемент у которого больше длина
////            }
////        });
//        //list.set(0,"September");//переназначает значение элемента по определенному индексу
//        //list.addAll(1,Arrays.asList("May","June","Agest")); // позволяет добавить кучу элементов из коллекции прямо в список
//        //list.remove("Febryary");// Удаление элемента списка
//        //list.remove(2);// Удаление элемента списка по индексу
//        //list.removeAll(); // удаление нескольких элементов списка
//        //list.removeIf(s -> s.length() > 5); // удаление через лямда выражеие
//
//
//        // list.removeIf(new Predicate<String>() { // удаление элемента списка через условие
//        //    @Override
//        //  public boolean test(String s) {
//        //     return s.length() > 5; // если длина строки больше 5
//        // }
//        //   });
//
////        System.out.println(list.get(0)); // метод get получение элемента списка по индексу
////        System.out.println(list);
////        System.out.println(list.contains()); // вернет истину или ложь если обьект есть или нет в списке
////        for (int i = 0; i < list.size(); i++) { // метод size возвращает количество элементов в списке
////            System.out.println(list.get(i)); // вывод поэлементно из списка
////        }
//
////        for (String s :list) {  // вывод списка через forech
////            System.out.println(s);
////
////        }
//
////Iterator iterator = list.iterator(); // указатель, по порядку указывает на каждый элемент спимка
////while(iterator.hasNext()){ // если ни разу не вызвать метод next у итератора то выдаст ошибку
////    System.out.println(iterator.next());// next () переключаеться на следующий элемент списка
////    iterator.remove(); //удаление итератора
////
////}
////        System.out.println(list);// вывод списка после удаления
////        ListIterator iterator = list.listIterator(); // может поменять удалить пройти не только вперед по спискку но и назад , это отличия от просто итератора
////                while(iterator.hasNext()){
////                    System.out.println(iterator.next());
////                    iterator.previous();// идет по списку с конца в начало
////                }
////        list.forEach(new Consumer() <String>{ \\Consumer<T> выполняет некоторое действие над объектом типа T, при этом ничего не возвращая
////            @Override
////            public void accept(String s) {
////            System.out.println(s);
////            }
////        }
//list.forEach(s -> System.out.println(s) );// лямда выражение консумера
//list.forEach(System.out::println);
//    }
//
//
//}
