package ru.GeekBrains.Lesson7_OOP_practice_and_working_with_strings;

public class Wall implements Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean obstacles(Disciplines disciplines) {
       String result = "";
        if (this.height<=disciplines.jump()){
            result = disciplines.getName()+ "Перепрыгнул";
            return true;
        }else {
            result  += disciplines.getName()+"Не перепрыгнул";
        }
        return false;
    }
}
