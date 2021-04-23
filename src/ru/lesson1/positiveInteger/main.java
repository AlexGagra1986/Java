package ru.lesson1.positiveInteger;

public class main {
    public static void main(String[] args) {
        int i  = 0;
        result( i);
    }

    static void result(int i){

        if (i<0 ){
            System.out.println("Повторите попытку, число отрицательное");
        }else {
            System.out.println("Поздравляем число: "+i+" Положительное");
        }

    }
}
