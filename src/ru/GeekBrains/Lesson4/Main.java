package ru.GeekBrains.Lesson4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    final int SIZE = 5;
    final char DOT_X = 'X';
    final char DOT_O = 'O';
    final char DOT_EMPTY = '*';
    char[][] map = new char[SIZE][SIZE];
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    public static void main(String[] args) {
        new Main().go();
    }
    void go() {
        initMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("YOU WON!");
                break;
            }
            if (isMapFull()) {
                System.out.println("SORRY");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("AI WON!");
                break;
            }
            if (isMapFull()) {
                System.out.println("SORRY!");
                break;
            }
        }
        System.out.println("GAME OVER.");
    }

    void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    void humanTurn() {
        int x, y;
        do {
            System.out.println("Enter X and Y :");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[y][x] = DOT_O;
    }

    void printMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE;j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    boolean checkWin(char dot) {
        int diag1, diag2, hor, ver;
        for (int i = 0; i < 4; i++) {
            hor = 0; ver = 0;
            for (int j = 0; j < 4; j++) {
                if (map[i][j] == dot){
                    hor++;
                }
                if (map[j][i] == dot){
                    ver++;
                }
            }
            if (hor == SIZE|| ver == SIZE) {
                return true;
            }
        }
        diag1 = 0; diag2 = 0;
        for (int i = 0; i < 4; i++) {
            if (map[i][i] == dot) {
                diag1++;
            }
            if (map[i][4 - i - 1] == dot) {
                diag2++;
            }
        }
        if (diag1 == 4 || diag2 == 4) {
            return true;
        }
        return false;
    }

    boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }
}
