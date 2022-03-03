import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ClassJ1Lesson3 {
    public static void main(String[] args){
        int[] arr= {4,8,41,33,25};
        System.out.println(Arrays.toString(arr));
    Random random= new Random();
        for (int i=0;i<20;i++) {
            System.out.print(random.nextInt(31) + " ");
        }
            System.out.println();

            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();
            String s= scanner.next();
            int b = scanner.nextInt();

            switch (s){
                case "+":
                    System.out.println("= "+(a+b));
                    break;
                case "-":
                    System.out.println("= "+(a-b));
                    break;
            }

        }
    }

