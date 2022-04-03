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
                new Cat("Dog1", 20, 0, 1),
                new Dog("Cat1", 200, 12, 0.2f)
        };
        for (Animal animal : animals) {
            System.out.println(animal + " run:" + animal.run() + " swim:" + animal.swim() + " jump:" + animal.jump());
        }
    }
}

class Cat extends Animal {
    Cat(String name, int run, int swim, float jump) {
        super(name, run, swim, jump);
    }

    @Override
    public Boolean run() {
        if (run <= 200)
            return true;
        return false;
    }

    @Override
    public Boolean swim() {
        if (swim == 0)
            return true;
        return false;
    }

    @Override
    public Boolean jump() {
        if (jump <= 2)
            return true;
        return false;
    }
}

class Dog extends Animal {
    Dog(String name, int run, int swim, float jump) {
        super(name, run, swim, jump);
    }

    @Override
    public Boolean run() {
        if (run <= 500)
            return true;
        return false;
    }

    @Override
    public Boolean swim() {
        if (swim <= 10)
            return true;
        return false;
    }

    @Override
    public Boolean jump() {
        if (jump <= 0.5)
            return true;
        return false;
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

    abstract Boolean run();

    abstract Boolean swim();

    abstract Boolean jump();

    @Override
    public String toString() {
        return name;
    }
}