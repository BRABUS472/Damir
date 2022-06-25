package home_work_2_3;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и
 * вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 * Посчитать, сколько раз встречается каждое слово.
 */

public class HomeWork2_3_1 {
    public static void main(String[] args) {

        ArrayList<String> words = new ArrayList<>();

        words.add("face");
        words.add("book");
        words.add("pen");
        words.add("apple");
        words.add("baby");
        words.add("look");
        words.add("pig");
        words.add("orange");
        words.add("dog");
        words.add("soon");
        words.add("face");
        words.add("summer");
        words.add("office");
        words.add("baby");
        words.add("soon");
        words.add("bad");
        words.add("face");
        words.add("picture");
        words.add("home");
        words.add("door");

        for (int j = 0; j < words.size(); j++) {
            int i = -1;
            Iterator<String> s_iterator = words.iterator();
            while (s_iterator.hasNext()) {
                String str_element = s_iterator.next();
                if (str_element.equals(words.get(j))) {
                    i++;
                    if (i > 0) {
                        s_iterator.remove();
                    }
                }
            }
            System.out.println(words.get(j) + " повтор " + i);
        }
    }
}