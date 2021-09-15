package ru.GeekBrains.Logging_14;
import org.apache.commons.lang3.ArrayUtils;
public class Main {
    public static void main(String[] args) {
        int array[] = {0,2,0,0,2,4,0,0,7};

        calc(array);
        cheakFoT(array);


    }

    public static void cheakFoT(int[] array) {
        System.out.println("");
        if (!cheakFalse(array)) System.out.println("Ложь");

        else {
            System.out.println("Истина");
        }
    }

    public static int[] calc(int[] array) {

        int array2[] = ArrayUtils.subarray(array, ArrayUtils.lastIndexOf(array, 4) + 1, ArrayUtils.getLength(array) + 1);
        print(array);
        print(array2);
        cheakF(array);



        return array2;
    }

    public static boolean cheakFalse(int[] array) {
        return (ArrayUtils.contains(array, 1) || ArrayUtils.contains(array, 4));

    }
    public static void cheakF(int[] ar) {
        int j = 0;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == 4) {System.out.println("Номер элемента " + i + " Число " + ar[i]+" найдено"); j++;}
        }
        if(j==0){throw new RuntimeException();}

    }


    public static int []  print(int[] ar) {
        for (int a = 0; a < ar.length; a++) {
            System.out.print(ar[a]);
        }
        System.out.println(" ");
        return ar;
    }
}
