package ru.GeekBrains.Lesson9_Exceptions;

public class MyArraySizeException extends Exception {

    public int i;
    public int j;

public MyArraySizeException (int i,int j){
    this.i = j;
    this.j = i;
}

    public MyArraySizeException() {

    }
}
