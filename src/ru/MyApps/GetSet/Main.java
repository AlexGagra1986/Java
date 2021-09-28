package ru.MyApps.GetSet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in); // подключаю класс сканер для ввода с клавиатуры данных
        int totalIncome = read.nextInt();// создаю переменную общий приход
        int taxPercent = read.nextInt();// создаю переменную процентная ставка




Income income = new Income(); // создаю экземпляр класса инком
income.totalIncome =totalIncome; // подключаю вводные данные о общем приходе к переменной в классе income
income.taxPercent = taxPercent; // подключаю вводные данные о общем приходе к переменной в классе income
income.setCalculate(); // подключаю сеттер
        System.out.println(income.getNetRevenue());// вывожу на экран результат

    }
}
