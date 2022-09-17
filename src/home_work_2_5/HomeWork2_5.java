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

        float min = getNumber("Введите первое число:");
        while (min<2){
            System.out.println("простое число должно быть больше 1");
            min=getNumber("Введите первое число:");
        }
        float max = getNumber("Введите второе число:");
        while ((max<2)||(max==min)) {
            System.out.println("простое число должно быть больше 1 и не должен равняться первому числу");
            max=getNumber("Введите второе число:");
        }

        if(min>max){
           float n=min;
            min=max;
            max=n;
        }
        int threadCount = getNumber("Введите количество потоков:");
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

    public static int getNumber(String message) {
        int x=0;
        System.out.println(message);
        while (!sc.hasNextInt()) {
            System.out.println("Ошибка, введите число:");
            sc = new Scanner(System.in);
        }
        x = sc.nextInt();
        while (x < 0) {
            System.out.println("число меньше 0 или равен 0, введите корректное число:");
            x = sc.nextInt();
        }
        return x;
    }

    public static void findPrimeNumber(int min, int max) {
        boolean b = true;
        for (int p = min; p <= max; p++) {
            for (int i = 2; i < p; i++) {
                if (p % i == 0) {
                    b = false;
                }
            }
            if (b)
                log(p);
            else b = true;
        }
    }
}