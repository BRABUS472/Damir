package draft.J2Lesson3;

import java.util.*;

public class CollectionLesson {
    public static void main(String[] args) {
        //начальная емкость элементов 10 при объявлении, при заполнении, выделяеться память в полтора раза
        //создание List, типа String
        ArrayList<String> dinosaurs = new ArrayList<>();
        //оператор add-добавление в лист
        dinosaurs.add("Compsognathus");
        dinosaurs.add("Amargasaurus");
        dinosaurs.add("Oviraptor");
        dinosaurs.add("Veloceraptor");
        dinosaurs.add("Deinonychys");
        dinosaurs.add("Dilophosaurus");
        dinosaurs.add("Gallimimus");
        dinosaurs.add("Triceratops");

        //удалить элемент по индексу или згачению dinosaurs.remove(3) или dinosaurs.remove("Gallimimus");

        //вывод количество элементов dinosaurs.size(), не емкость
        System.out.println("Size of dinosaurus list is: " + dinosaurs.size());

        //вывод списка элементов
        for (String d : dinosaurs) {
            System.out.println(d);
        }

        //уменьшение емкости List до минимума(для перерасхода памяти):
        dinosaurs.trimToSize();

        //получить массив из ArrayList
        String[] dino = new String[dinosaurs.size()];

        //добавление в ArrayList элементов с помощью класса Dinosaur

        Dinosaur[] dn = new Dinosaur[]{
                new Dinosaur(230, "Theropoda", "Compsognathus"),
                new Dinosaur(260, "Theropoda", "Veloceraptor"),
                new Dinosaur(200, "Sauropod", "Triceratops")
        };

        ArrayList<Dinosaur> dinos = new ArrayList<>();

        //Добавление элементов массива dn в лист dinos
        dinos.addAll(Arrays.asList(dn));

        System.out.println(dinos);


        //найти индекс элемента, вернет -1 если такого элемента нет
        int index = dinosaurs.indexOf("Veloceraptor");
        System.out.println(index);

        //упорядочить элементы в списке Dinos по наименованию, без учета регистра в Прямом порядке (в данном случае по имени)
        //Comparator-сравниватель
        dinos.sort(Comparator.comparing(Dinosaur::getName, String.CASE_INSENSITIVE_ORDER));
        //упорядочить элементы в списке Dinos по наименованию, без учета регистра в ОБРАТНОМ порядке (в данном случае по имени)
        dinos.sort(Comparator.comparing(Dinosaur::getName, String.CASE_INSENSITIVE_ORDER).reversed());
        for (Dinosaur din : dinos) {
            System.out.println(din.getName());
        }
        //LinkedList - List который иммет ссылку на предыдущий и последющий элемент. При удалении элемента перепишутся ссылки предыдущего и последующего элемента
        //создание LinkedList типа String

        LinkedList<String> auto = new LinkedList<>();

        //Добавление элементов в LinkedList c помощью add, addLast-последний элемент, addFirst-первый элемент
        auto.add("BMW");
        auto.add("Toyota");
        auto.add("Jeep");
        auto.add("Uaz");
        auto.add("Ferrari");
        auto.addLast("Lotus");
        auto.addFirst("Mazda");

        auto.add(2, "Alfa Romeo");//будет добавлен в конец списка если не указать параметр

        System.out.println("Contest of auto " + auto);

        //удаление элементов
        auto.remove(3);
        auto.remove(2);

        //удаление первого и последнего элемента
        auto.removeFirst();
        auto.removeLast();


        System.out.println("Contest of auto, after deleted " + auto);

        //получить элемент посредством  Get и Set
        String auto_name = auto.get(2);
        //в индексе 2 изменить значение
        auto.set(2, auto_name + " was changed");
        System.out.println("Auto after change: " + auto);

        //Hash-неоторое число фиксированной длины, которое можно получить применяя его к какого либо объекту. К примеру к строке

        //возможная запись = new HashSet<T>(16,0.25)
        //16-емкость (при заполнении увеличивается в два раза, если не указана емкость).
        //0.25-load factor-при заполнении емкости на 0.25 будет увеличена емкость в два раза, чем меньше load factor тем меньше вероятность коллизии(два объекта с одним хэшем) .

        //создание HashSet

        HashSet<String> h_set = new HashSet<>();

        //добавление элементов в HashSet

        h_set.add("Compsognathus");
        h_set.add("Amargasaurus");
        h_set.add("Oviraptor");
        h_set.add("Veloceraptor");
        h_set.add("Deinonychys");
        h_set.add("Dilophosaurus");

        //вывод HashSet

        System.out.println(h_set);

        
        //Iterator-поочередно перебирает элементы коллекции

        //получение итератора с помощью метода .iterator
        Iterator<String> s_iterator = h_set.iterator();

        //перебор с помощью метода .hasNext, .hasNext-говорит о том существует ли следующий элемент или нет

        while (s_iterator.hasNext()){
            String h_set_element = s_iterator.next();
            System.out.print(h_set_element+ ", ");
        }


        //TreeSet - создает коллекция которое для хранения использует древовидную структуру. Элементы распологаются в отсортированном порядке

        TreeSet<String> t_set = new TreeSet<>();

        t_set.add("Compsognathus");
        t_set.add("Amargasaurus");
        t_set.add("Oviraptor");
        t_set.add("Veloceraptor");
        t_set.add("Deinonychys");
        t_set.add("Dilophosaurus");

       //выводит в отсортированном порядке по алфавиту
        System.out.println(t_set);


        //компараторы для TreeSet и TreeMap

        //TreeSet<String> ts_set = new TreeSet<>(new DinosaurComparatop());
        TreeSet<String> ts_set = new TreeSet<>(new DinosaurComparatop().reversed());

        ts_set.add("Compsognathus");
        ts_set.add("Amargasaurus");
        ts_set.add("Oviraptor");
        ts_set.add("Veloceraptor");
        ts_set.add("Deinonychys");
        ts_set.add("Dilophosaurus");

        System.out.println("TreeSet sorting: ");
        for (String din: ts_set){
            System.out.println(din);
        }


        //LinkedHashSet - наполнение коллекции без сортировки, конструкторы от HashSet

        LinkedHashSet<String> lh_set = new LinkedHashSet<>();

        lh_set.add("Compsognathus");
        lh_set.add("Amargasaurus");
        lh_set.add("Oviraptor");
        lh_set.add("Veloceraptor");
        lh_set.add("Deinonychys");
        lh_set.add("Dilophosaurus");

        System.out.println(lh_set);


        //HashMap-хэштаблица(ключи и значения к ключам). емкость 16, коэф заполнения 0.75.
        //заполнение и извлечение в может быть в разном порядке

        //объявление коллекции. Сначала ключ потом тип
        HashMap<Integer, String>hm =new HashMap<>();

        //добавление с помощью put

        hm.put(1, "BMW");
        hm.put(2, "UAZ");
        hm.put(3, "Ferrari");
        hm.put(4, "Lamborghini");

        //получаем содержимое с помощью .entrySet
        Set<Map.Entry<Integer, String>> set = hm.entrySet();

        //получение ключей .getKey() и значений .getValue()
        for(Map.Entry<Integer, String> o : set){
            System.out.print(o.getKey()+": ");
            System.out.println(o.getValue());
        }
    }
}