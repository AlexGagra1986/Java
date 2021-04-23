package ru.lesson1.logicheskiyMetod;

public class main {
    public static void main(String[] args) {
        int i = 0;
        boolean x = false;
        res(i,x);
    }
    static void res(int i, boolean x){
        if(i<0){
            x  = false;
            System.out.println("Результат : "+x);
        }else{
            x = true;
            System.out.println("Результат : "+x);
        }

    }
}
