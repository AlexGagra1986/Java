package ru.GeekBrains.Lesson1.method;

public class main {
    public static void main(String[] args) {
        float a,b,c,d;
        a = 5.5f;
        b=8.8f;
        c=4.1f;
        d=3.3f;
        Result(a,b,c,d);


    }

    private static void Result(float a, float b, float c, float d) {
        float x = a * (b + (c / d));
        System.out.println(x);
    }
}
