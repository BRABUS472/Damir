package home_work_3;

import java.util.Random;
import java.util.Scanner;

/*Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3
попытки угадать это число. При каждой попытке компьютер должен сообщить больше ли
указанное пользователем число, чем загаданное, или меньше. После победы или проигрыша
выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
*/
public class HomeWork3_1 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = 1;
        while (n == 1) {
            Random rand = new Random();
            int r = rand.nextInt(10);
            System.out.println("рандомное число = " + r);
            for (int i = 3; i > 0; i--) {
                int d = getNumber("Введите число в пределаж от 0 до 9");
                if (d == r) {
                    System.out.println("Вы угадали число");
                    break;
                } else if (d > r) {
                    System.out.println("число  больше загаданного");
                    if (i > 1) {
                        System.out.println("осталось " + (i - 1) + " попыток");
                    } else {
                        System.out.println("Вы проиграли");
                    }
                } else {
                    System.out.println("число меньше загаданного");
                    if (i > 1) {
                        System.out.println("осталось " + (i - 1) + " попыток");
                    } else {
                        System.out.println("Вы проиграли");
                    }
                }
            }
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет)");
            n = sc.nextInt();
        }

    }

    public static int getNumber(String messeage) {
        int x;
        do {
            System.out.println(messeage);
            x = sc.nextInt();
            if (x < 0 || x > 9) {
                System.out.println("число не находиться в пределах от 0 до 9");
            }
        } while (x < 0 || x > 9);
        return x;
    }
}



