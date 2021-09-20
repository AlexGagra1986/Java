package ru.MyApps.Time;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();

        Time(x,y,z);
    }

    private static void Time(int x, int y, int z) {
        System.out.println("Введите числа: ");
        int min = x+y+z;
        System.out.println("Сумма общего времяни: "+ min);
        float res = min/60f;
        int hours = (int) res;
        float m = res-hours;
         m = m*60;
        int res2 = (int)m;
        System.out.println(hours+","+res2);
    }
}
