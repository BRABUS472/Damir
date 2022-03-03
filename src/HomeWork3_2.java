import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
/* Создать массив из слов
 String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
 "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
 "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
 При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
 сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если
 слово не угадано, компьютер показывает буквы которые стоят на своих местах.
 apple – загаданное
 apricot - ответ игрока
 ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
 Для сравнения двух слов посимвольно, можно пользоваться:
 String str = "apple";
 str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
 Играем до тех пор, пока игрок не отгадает слово
 Используем только маленькие буквы
 */
public class HomeWork3_2 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random rand = new Random();
        int r = rand.nextInt(words.length);
        System.out.println("рандомное слово = " + words[r]);
        System.out.println(Arrays.toString(words));
        System.out.println("Отгадай каке слово я загадал:");
        String word = words[r];

        int count = 0;//подсчет количества символов в рандомном слове
        for (int f = 0; f < word.length(); f++) {
            count++;
        }
       String scan = sc.nextLine();
        while (word!=scan){
        if (word.equals(scan)) {
            System.out.println("Вы выиграли!");
            break;
        } else {
            for (int i = 0; i < 15; i++) {
                int count1 = 0;//подсчет количества символов в сканированном слове
                for (int f = 0; f < scan.length(); f++) {
                    count1++;
                }
                if ((i < count) && (i < count1)) {
                    if (word.charAt(i) == scan.charAt(i)) {
                        System.out.print(scan.charAt(i));

                    } else {
                        System.out.print("#");
                    }
                } else {
                    System.out.print("#");
                }
            }
               System.out.println();
               System.out.println("повторите попытку");
               scan = sc.nextLine();

        }
    }
    }
}

