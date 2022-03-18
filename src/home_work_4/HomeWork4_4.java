package home_work_4;

import java.util.Random;
import java.util.Scanner;

public class HomeWork4_4 {
    final int SIZE = 3;
    final char DOT_X = 'x';
    final char DOT_O = 'o';
    final char DOT_EMPTY = '.';
    char[][] map = new char[SIZE][SIZE];
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    public static void main(String[] args) {
        new HomeWork4_4();
    }

    HomeWork4_4() {
        initMap();
        while (true) {
            humanTurn();
            if (checkWin(DOT_X)) {
                System.out.println("YOU WON");
                break;
            }
            if (isMapFull()) {
                System.out.println("SORRY, DRAW!");
                break;
            }
            aiTurn(DOT_O, DOT_X);
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("AI WIN");
                break;
            }
            if (isMapFull()) {
                System.out.println("SORRY, DRAW!");
                break;
            }
        }

        System.out.println("GAME OVER");
        printMap();
    }

    void initMap() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                map[i][j] = DOT_EMPTY;
    }

    void printMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    void humanTurn() {
        int x, y;
        do {
            System.out.println("Enter X and Y (1...3)");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    void aiTurn(char dot, char enemyDot) {
        int x, y;
        for (x = 0; x < SIZE; x++)
            for (y = 0; y < SIZE; y++)
                if (isCellValid(x, y)) {
                    map[y][x] = enemyDot;
                    if (checkWin(enemyDot)) {
                        map[y][x] = dot;
                        return;
                    }
                    map[y][x] = DOT_EMPTY;
                }
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[y][x] = DOT_O;
    }

    boolean isMapFull() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (map[i][j] == DOT_EMPTY)
                    return false;
        return true;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE)
            return false;
        return map[y][x] == DOT_EMPTY;
    }

    boolean checkWin(char dot) {
        for (int i = 0; i < SIZE; i++) {
            if ((map[i][0] == dot && map[i][1] == dot && map[i][2] == dot) ||
                    (map[0][i] == dot && map[1][i] == dot && map[2][i] == dot)) return true;
        }
        if ((map[0][0] == dot && map[1][1] == dot && map[2][2] == dot) ||
                (map[2][0] == dot && map[1][1] == dot && map[0][2] == dot)) return true;
        return false;
    }
}
