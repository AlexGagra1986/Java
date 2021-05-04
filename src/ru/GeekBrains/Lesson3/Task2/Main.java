package ru.GeekBrains.Lesson3.Task2;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] ar = new int[]{1,1,1,1,1,1,1,1};
        int[] BalanceLeft = new int[ar.length/2];
        int[] BalanceRight = new int[ar.length-BalanceLeft.length];


Balance(ar,BalanceLeft,BalanceRight);


    }

    private static void Balance(int[]ar,int [] BalanceRight,int [] BalanceLeft) {
       System.arraycopy(ar,0,BalanceLeft,0,BalanceLeft.length);
       System.arraycopy(ar,BalanceLeft.length,BalanceRight,0,BalanceRight.length);

              int Result1 = IntStream.of(BalanceRight).sum();
              int Result2 = IntStream.of(BalanceLeft).sum();
        System.out.println("Сумма Правой Части: "+Result1);
        System.out.println("Сумма Левой Части: "+Result2);
              boolean Result3 = false;
              if (Result1!=Result2) {
                     Result3 = false;
               }else{
                  Result3 = true;
              }
        System.out.println("Логическое значение: "+Result3);


    }






    }

