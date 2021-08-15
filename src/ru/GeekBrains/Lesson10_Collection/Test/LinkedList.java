package ru.GeekBrains.Lesson10_Collection.Test;

import java.util.List;

public class LinkedList {
    public static void main(String[] args) {
        //нет массиа внутри , в нем есть объекты типа моды Node
        //в каждой Ноде есть сам элемент и ссылка на предидущий и ссылка на следующий элемент
        // в линк листе содержуться две сущности это Node first и Node last
        List <String> list = (List<String>) new LinkedList();
        list.add("dfdg");


        for (String s : list) {
            System.out.println(s);
        }

        //время 1:44
    }
}
