package ru.GeekBrains.Lesson1.intMethod;

public class mainInt {
    public static void main(String[] args) {
        int a = 5;
        int b = 11;
       boolean z = false;
        Res( a, b, z);

    }

    private static void Res(int a, int b,boolean z) {

        int c = a+b;
        if (c>10 & c<20){
            z = true;
        } else{
            z = false;
        }
        System.out.println(z);
    }



}
