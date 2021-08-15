package ru.GeekBrains.Lesson7_OOP_practice_and_working_with_strings;

public class Main {
    public static void main(String[] args) {
Human human = new Human("rtghgfh",100,11);
Cat cat = new Cat("Барсик",5, 33);
Robot robot = new Robot("Бендер",100, 33);


Wall wall = new Wall(100);
Road road = new Road(10);



Disciplines[] trainees = {human,cat,robot};
Obstacle[] obstacles = {wall,road};

        for (int i = 0; i < trainees.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                if(obstacles[j].obstacles(trainees[i])) {
                    System.out.println(trainees[i].getName()+" Дисциплина Пройдена");
                    continue;
                }
                else System.out.println(trainees[i].getName()+" Снят с дистанции");
                break;
            }
        }

    }
}
