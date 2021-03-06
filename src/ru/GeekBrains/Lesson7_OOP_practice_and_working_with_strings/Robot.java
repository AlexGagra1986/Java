package ru.GeekBrains.Lesson7_OOP_practice_and_working_with_strings;

public class Robot implements Disciplines{
    private String name;
    private int height;
    private int length;

    public Robot(String name, int height, int length) {
        this.name = name;
        this.height = height;
        this.length = length;
    }

    @Override
    public int run() {
        System.out.println(name+" Пробежал на "+height+ " м");
        return length;
    }

    @Override
    public double jump() {
        System.out.println(name+" Прыгнул на "+height+ " м");
        return height;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getHeightJump() {
        return height;
    }


}
