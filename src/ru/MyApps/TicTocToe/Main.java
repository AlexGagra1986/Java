package ru.MyApps.TicTocToe;

import java.util.Scanner;

public class Main {
    public  final char X = 'X';
    public  final static char Space = '+';
    public  static final int SIZE = 5;
    public static char filed[][] = new char[SIZE][SIZE];



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        PrintField();
        Field();
    }




    static void PrintField() {
        for (int i = 0; i < filed.length; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.println(filed[i][j]);
            }

        }

    }

    static void Field() {
        for (int i = 0; i < filed.length; i++) {
            System.out.println("");
            for (int j = 0; j < filed.length; j++) {
               filed[i][j] = Space;
                System.out.println(" ");
            }
        }
    }


}

