package ru.MyApps.Binary;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int  x = scanner.nextInt();
        System.out.println("Введите десятичное число: "+x);
        System.out.println(Converter.toBinary(x));

    }
}
