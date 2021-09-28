package ru.MyApps.Inheritance;

public class Main {
    public static void main(String[] args) {
        Standart standart = new Standart();
        Pro pro = new Pro();
        standart.write();
        standart.draw();

       pro.write();
       pro.draw();
       pro.useEffects();
       pro.changeResolution();
    }
}
