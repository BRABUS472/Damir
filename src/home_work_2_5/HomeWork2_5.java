package home_work_2_5;
/*
заставить комьютер находить простые числа
ввести числа. три параметра. Нижняя граница, верхняя граница, сколько патоков расспаралелить(попросить пользователя. пример от 1221...32457)
распаралелить рассчет по патокам
*/


import java.util.Scanner;

public class HomeWork2_5 {
    public static void log(String message) {
        System.out.println("[" + Thread.currentThread().getName() + "] " + message);
    }

    public static void log(int message) {
        log(String.valueOf(message));
    }

    public static void main(String[] args) {

        float min = getNumber();
        float max = getNumber();
        int threadCount = getNumber();
        for (int i = 1; i <= threadCount; i++) {

        }
        for (int i = 0; i < threadCount; i++) {
            float minimum = ((max - min) / threadCount) * i + min;
            float maximum = ((max - min) / threadCount) * (i + 1) + min;
            System.out.println("Min, max " + Math.ceil(minimum) + ", " + Math.floor(maximum));
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    findPrimeNumber((int) Math.ceil(minimum), (int) Math.floor(maximum));
                }
            });
            thread.start();
        }
    }

    public static Scanner sc = new Scanner(System.in);

    public static int getNumber() {
        int x;
        System.out.println("Введите число:");
        x = sc.nextInt();
        while (x < 0) {
            System.out.println("число меньше 0, введите корректное число:");
            x = sc.nextInt();
        }
        return x;
    }

    public static void findPrimeNumber(int min, int max) {
        boolean b = true;
        for (int P = min; P <= max; P++) {
            for (int i = 2; i < P; i++) {
                if (P % i == 0) {
                    b = false;
                    break;
                }
            }
            if (b)
                log(P);
            else b = true;
        }
    }
}