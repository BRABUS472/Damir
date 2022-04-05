package draft;

public class J1Lesson6 {
    public static void main(String[] args) {
        IAnimal[] animals = { // в качестве базового типа можно указывать интерфейс который реализует базовый класс
                new Cat1("Kruzik", "white", 3),
                new Dog1("Shark", "black", 5)
    };
      for (IAnimal animal:animals){
          System.out.println(animal+"-"+animal.voice());
      }
        //draft.Animal animal = new draft.Animal("-","-",-1); выйдет ошибка из - за абстракции класса animal
        //System.out.println(animal+"-"+animal.voice());
    }
}

class Cat1 extends Animal1{
    Cat1(String name, String color, int age){
        super(name,color,age);
    }
    @Override
    public String voice(){
        return "meow";
    }
}
class Dog1 extends Animal1{
    Dog1(String name, String color, int age){
        super(name,color,age);
    }
    @Override
    public String voice(){
        return "gau-gau";
    }
}
interface IAnimal { // интерфейс
    String voice();
}

abstract class Animal1 implements IAnimal  {  //абстракт Не дает создать объект данного класса, но дает возможность наследования. Implements реализация интерфейса (подключаем интерфейся)
    String name;
    String color;
    int age;
    Animal1(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age= age;
    }

    //String voice () {  делаем метод абстрактным
    // return "Sound";
    //}

   // abstract String voice (); // сделали метод абстрактным

    @Override
    public String toString(){
        return name + " " + color + " " + age;
    }
}