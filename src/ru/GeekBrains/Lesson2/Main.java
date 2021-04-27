package ru.GeekBrains.Lesson2;

public class Main {
    public static void main(String[] args) {


        int[] ArrayInt1 = {0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1};

        for (int i = 0; i < ArrayInt1.length; i++) {
            if (ArrayInt1[i] == 0) {
                ArrayInt1[i] = 1;
            } else if (ArrayInt1[i] == 1) {

                ArrayInt1[i] = 0;
            }
            System.out.print(ArrayInt1[i]);

        }
        System.out.println("");

        int ArrayInt2[] = new int[8];
        for (int i = 0; i < ArrayInt2.length; i++) {
            ArrayInt2[i] = i * 3;
            System.out.print(":" + ArrayInt2[i]);

        }

        System.out.println("");

        int[] ArrayInt3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8,9,1};

        for (int i = 0; i < ArrayInt3.length; i++) {
            if (ArrayInt3[i] < 6) {
                ArrayInt3[i] = ArrayInt3[i] * 2;
            }
            System.out.print(":" + ArrayInt3[i]);
        }
        System.out.println(" ");

        int ArrayInt4[][] = new int[5][5];

        for (int i = 0; i < ArrayInt4.length; i++) {
            for (int j = 0; j < ArrayInt4.length; j++) {
                ArrayInt4[i][j] = 0;
                if (ArrayInt4[i] == ArrayInt4[j]) {
                    ArrayInt4[i][j] = 1;
                } else {
                    ArrayInt4[i][j] = 0;
                }

                System.out.print(ArrayInt4[i][j] + " ");


            }
            System.out.println("");

        }
        int max = 0;
        int min = 0;
        int[] ArrayInt5 = {1, 5, 3, 2, 4, 5, 2, 4, 8,10,1};
        for(int i = 0;i<ArrayInt5.length;i++){
            for(int j = 1;j<ArrayInt5.length;j++){
                if(ArrayInt5[i]>ArrayInt5[j]){
                    max = ArrayInt5[i];
                }else {
                    min =ArrayInt5[i];
                }
            }


    }
        System.out.print("Максимальный Элемент: "+max+"  "+"Минимальный Элемент: "+ min);
    }
}











