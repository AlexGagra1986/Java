package ru.GeekBrains.Lesson7_OOP_practice_and_working_with_strings;

public class Road implements Obstacle{
    private int length;

    public Road(int length) {
        this.length = length;
    }


    @Override
    public boolean obstacles(Disciplines disciplines) {
        String result = "";
        if (this.length<=disciplines.run()){
            result = disciplines.getName()+ " Пробежал дистанцию";
            return true;
        }else {
            result  += disciplines.getName()+" Не Пробежал дистанцию";
        }
        return false;
    }
}

