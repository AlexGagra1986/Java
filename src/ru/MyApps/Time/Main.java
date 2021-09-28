package ru.MyApps.Time;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int x = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int y = scanner.nextInt();
        System.out.print("Введите третье число: ");
        int z = scanner.nextInt();


        Time(x,y,z);
    }

    private static void Time(int x, int y, int z) {

        int sum = x+y+z;
        System.out.println("Сумма общего времяни: "+ sum+" мин");
        float res1 = sum/60f;
        int hours = (int) res1;
        float m = res1-hours;
         m = m*60;
        int res2 = (int)m;
        System.out.print(hours+","+res2+" ч.");
    }
}
