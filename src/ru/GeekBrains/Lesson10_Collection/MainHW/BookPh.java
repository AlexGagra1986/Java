package ru.GeekBrains.Lesson10_Collection.MainHW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookPh {
    private Map <String, List<String>> dr = new HashMap<>();
    private List<String>  numbers;


    public void add(String surname, String number ){
        if (dr.containsKey(surname)){
            numbers = dr.get(surname);
            numbers.add(number);
            dr.put(surname,numbers);
        }else {
            numbers = new ArrayList<>();
            numbers.add(number);
            dr.put(surname,numbers);
        }
    }
    public List<String> get(String surname){
        return dr.get(surname);
    }

}
