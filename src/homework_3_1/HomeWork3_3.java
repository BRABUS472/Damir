/*
3. Задача:
a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу
фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
c. Для хранения фруктов внутри коробки можно использовать ArrayList;
d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта
и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую
коробку с той, которую подадут в compare() в качестве параметра. true – если их массы
равны, false в противоположном случае. Можно сравнивать коробки с яблоками и
апельсинами;
f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются
объекты, которые были в первой;
g. Не забываем про метод добавления фрукта в коробку
 */

package homework_3_1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeWork3_3 {
    public static void main(String[] args) {
        Orange orange = new Orange();
        Apple apple = new Apple();
        Box<Orange> orangeBox1 = new Box();
        Box<Orange> orangeBox2 = new Box();
        Box<Apple> appleBox1 = new Box();
        orangeBox1.add(new Orange());
        orangeBox1.add(new Orange());
        orangeBox1.add(new Orange());

        for (int i = 0; i < 3; i++) {
            orangeBox2.add(new Orange());
        }

        for (int i = 0; i < 5; i++) {
            appleBox1.add(new Apple());
        }

        Float orange1Weight = orangeBox1.getWeight();
        Float orange2Weight = orangeBox2.getWeight();
        Float apple1Weight = appleBox1.getWeight();
        System.out.println("Weight box 1 orange :" + orange1Weight);
        System.out.println("Weight box 2 orange :" + orange2Weight);
        System.out.println("Weight box 1 apple :" + apple1Weight);


        System.out.println("compare weight orange1 and apple1 " + orangeBox1.compare(appleBox1));
        System.out.println("compare weight orange2 and apple1 " + orangeBox2.compare(appleBox1));

        orangeBox1.moveAt(orangeBox2);
    }
}





