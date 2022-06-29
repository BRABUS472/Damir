package draft.J2Lesson3;

import java.util.Comparator;

public class DinosaurComparatop implements Comparator<String> {

    @Override//указываем, как именно надо проводить сравнение
    public int compare(String s1, String s2){
        //сравниваниев строку s1 и s2 игнорирую регистр
      return s1.compareToIgnoreCase(s2);
      // return s2.compareToIgnoreCase(s1);-сортирует наоборот
    }
   // сравнивает параметры типа Dinosaur d1 и d2
    /*
    @Override
    public int compare(Dinosaur d1, Dinosaur d2){

        //сравниваем параметры типа getName(), можно выбрать другой элемент

        return d1.getName().compareTo(d2.getName())
    }
*/
}
