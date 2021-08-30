package ru.GeekBrains.Lesson11_Generalizations;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer arr1[] = {1,2,3,4};

        Ch(arr1);
        arList(arr1);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Box<Orange> orange = new Box<>();
        Box<Apple> apple = new Box<>();
        orange.addF(new Orange(),12);
        orange.addF(new Orange(),12);
        orange.addF(new Orange(),12);
        apple.addF(new Apple(),12);
        apple.addF(new Apple(),12);
        apple.addF(new Apple(),12);


        System.out.println("Box Orange: "+orange.weghtBox());
        System.out.println("Box Apple: "+apple.weghtBox());

        System.out.println(apple.compare(orange));
    }




    //    Arrays.toString(arr)) возвращает строковое представление одномерного массива, разделяя элементы запятой.
//    Вместо того чтобы перебирать массивы циклом for, можно воспользоваться этим методом для вывода элементов на консоль
    public static void Ch(Object[] arr){
        System.out.println(Arrays.toString(arr)+"First array,no change");
        Object temp=0;
        int n = 2/arr.length;
        for (int i = 0; i < arr.length-1; i++) {
            temp = arr[i+1];
            arr[i+1]=arr[i];
            arr[i]=temp;
        }
        System.out.println( Arrays.toString(arr)+"Second array change");
    }
    public static <T> void arList(T[]arr) {
        ArrayList<T> arList = new ArrayList<>(Arrays.asList(arr));
        System.out.println(arList+"ArrayList");
    }

}

