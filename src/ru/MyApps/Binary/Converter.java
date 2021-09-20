package ru.MyApps.Binary;

import static java.lang.Integer.parseInt;

public class Converter {
    public static int toBinary(int num){
        String binary = "";

        while (num>0){
            binary = (num%2)+binary;
            num/=2;
        }
        int x = Integer.parseInt(binary);
        return x;
    }


}
