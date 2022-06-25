package home_work_2_3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
 * телефонных номеров. В этот телефонный справочник с помощью метода add() можно
 * добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует
 * учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 * тогда при запросе такой фамилии должны выводиться все телефоны. Желательно не добавлять
 * лишний функционал (дополнительные поля (имя, отчество, адрес), взаимодействие с пользователем
 * через консоль и т.д). Консоль использовать только для вывода результатов проверки телефонного
 * справочника
 */

public class HomeWork2_3_2 {
    public static void main(String[] args) {

        Subscriber[] phoneBooks = new Subscriber[]{
                new Subscriber(4666244, "Fedorov"),
                new Subscriber(8555644, "Sidorov"),
                new Subscriber(845522, "Sidorov"),
                new Subscriber(5224431, "Ivanov"),
                new Subscriber(779921, "Ivanov")
        };

        ArrayList<Subscriber> PhoneBooks = new ArrayList<>();

        PhoneBooks.addAll(Arrays.asList(phoneBooks));

        PhoneBooks.add(new Subscriber(45565, "Ivanov"));
        PhoneBooks.add(new Subscriber(999556, "Fedorov"));

        for (Subscriber ph : PhoneBooks) {
            System.out.println(ph.getName() + " " + ph.getNumber());
        }

        String name = "Fedorov";

       /* Scanner in = new Scanner(System.in);
        System.out.println("Введите фамилию");
        String name = in.nextLine();
        System.out.println(name);
*/

        int i = 0;
        for (Subscriber ph : PhoneBooks) {
            if (ph.getName().equals(name)) {
                System.out.println("Список номеров телефонов с фамилией " + name + " " + ph.getNumber());
                i++;
                System.out.println(i);
            }
        }
        if (i == 0) {
            System.out.println("Номера с искомой фамилией не найдены");
        }
    }
}
