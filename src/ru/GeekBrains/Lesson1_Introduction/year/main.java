package ru.GeekBrains.Lesson1_Introduction.year;

import java.io.*;

public class main {
     

    public static void main(String[] args) throws IOException {
    int a  = 1965;
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println("Enter Date: ");
        a = Integer.parseInt(bufferedReader.readLine());

     res(a);
    }

    private static void res(int a){


        if (a %100==0 && a %400 ==0 )
            System.out.println("количество дней в году: 366 "+ " Год Высокосный" );

        else if (a % 4 == 0 && a % 100 > 0)
            System.out.println("количество дней в году: 366"+ " Год Высокосный");


        else if (a % 100 == 0)
            System.out.println("количество дней в году: 365"+ " Год не Высокосный" );

        else
            System.out.println("количество дней в году: 365"+ " Год не Высокосный" );

    }
}
