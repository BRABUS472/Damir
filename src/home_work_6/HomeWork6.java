/*
1 Создать классы Собака и Кот с наследованием от класса Животное.
2 Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве
параметра каждому методу передается величина, означающая или длину препятствия (для
бега и плавания), или высоту (для прыжков).
3 У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; прыжок: кот
2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).
4 При попытке животного выполнить одно из этих действий, оно должно сообщить результат в
консоль. (Например, dog1.run(150); -> результат: run: true)
 */
package home_work_6;

public class HomeWork6 {
    public static void main(String[] args) {
        Animal[] animals = {
                new Cat("Dog1", 200, 0, 2),
                new Dog("Cat1", 500, 10, 0.5f)
        };
        for (Animal animal : animals) {
            System.out.println(animal + "\nrun:" + animal.run(20) + " swim:" + animal.swim(20) + " jump:" + animal.jump(2));
        }
    }
}

class Cat extends Animal {
    Cat(String name, int run, int swim, float jump) {
        super(name, run, swim, jump);
    }

    @Override
    public Boolean swim(int distance) {
        return false;
    }
}

class Dog extends Animal {
    Dog(String name, int run, int swim, float jump) {
        super(name, run, swim, jump);
    }

}
abstract class Animal {
    String name;
    int run;
    int swim;
    float jump;

    Animal(String name, int run, int swim, float jump) {
        this.name = name;
        this.run = run;
        this.swim = swim;
        this.jump = jump;
    }

    public Boolean run(int distance) {
        return run >= distance;
    }

    public Boolean swim(int distance) {
        return swim >= distance;
    }

    public Boolean jump(float height) {
        return jump >= height;
    }

    @Override
    public String toString() {
        return "name:"+name+"\nParameter:\nrun:"+run+"\nswim:"+swim+"\njump:"+jump;
    }
}