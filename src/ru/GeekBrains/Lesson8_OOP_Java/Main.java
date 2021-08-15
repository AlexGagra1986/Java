package ru.GeekBrains.Lesson8_OOP_Java;



public class Main {
    private static int TIME = 0;
    public static void main(String[] args) {


        Cat[] cat = new Cat[3];
        cat[0] = new Cat("Барсик", 3, 3);
        cat[1] = new Cat("Мурзик", 5, 5);
        cat[2] = new Cat("Василий", 2, 6);
        Plate plate = new Plate(10);


        System.out.println("Три кота"+ cat[0].getName() + ", " + cat[1].getName() + " и " + cat[2].getName() + ", Едят" + cat[0].getSatietyTime() + ", " + cat[1].getSatietyTime() + " и " + cat[2].getSatietyTime() + " час соответственно.");
        System.out.println("Сейчас в миске " + plate.getFood() + " гр." +" .\n");

        do {
            for (Cat i : cat) {
                if (i.getSatiety() == 0) {
                    if (!plate.checkFood(i.getAppetite())) {
                        plate.increaseFood();
                    }
                    i.eat(plate);
                    System.out.println("Кот " + i.getName() + " съел " + i.getAppetite() + " гр.  "  + " через  " + (i.getSatiety()+" ч." ));
                }


                i.setSatiety(i.getSatiety() - 1);
            }
            System.out.println("\nС момента прошло " + TIME + " ч. В миске осталось " + plate.getFood() + " гр. корма.\n");
            TIME++;

        } while (TIME <= 24);
    }
}




