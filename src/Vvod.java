import java.util.Scanner;

public class Vvod {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        int d =getNumberFrom("Введите число в пределаж от 5 до 10",5,10);
        System.out.println("d="+d);
    }
    public static int getNumberFrom(String messeage,int min,int max) {
        int x;
        do{
            System.out.println(messeage);
            x=sc.nextInt();
        } while (x<min||x>max);
        return x;
    }
}
