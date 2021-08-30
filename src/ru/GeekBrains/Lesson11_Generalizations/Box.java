package ru.GeekBrains.Lesson11_Generalizations;

import java.util.ArrayList;

public class Box<T extends Fruts>{

    private ArrayList<T> box= new ArrayList<T>();
    public Box(){}




    public boolean compare(Box box) {
        if(weghtBox() == box.weghtBox()) return true;
        return false;
    }
    
    

    public float weghtBox() {
        float wBox = 0;
        for (T b:box) {
            wBox += b.weghtBox();
        }
return  wBox;
        }



        public void addF(T frut,int sum){
            for (int i = 0; i < sum; i++) {
                box.add(frut);
            }
        }
    }





