package home_work_7;
/*Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
(например, в миске 10 еды, а кот пытается покушать 15-20).
 Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту
удалось покушать (хватило еды), сытость = true.
Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть
наполовину сыт (это сделано для упрощения логики программы).
Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и
потом вывести информацию о сытости котов в консоль.
Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
*/

public class HomeWork7 {
    public static void main(String[] args) {
        Cat[] catArr = new Cat[3];
        catArr[0] = new Cat("Barsik", 40);
        catArr[1] = new Cat("Murzik", 50);
        catArr[2] = new Cat("Dusiy", 60);

        Plate plate = new Plate(100);
        plate.info();
        for (Cat cat : catArr) {
            System.out.println(cat.name + " satiety: " + cat.isSatiety(plate.food));
            cat.eat(plate);
            plate.info();
        }
    }
}

class Plate {
    int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) {
        if (food >= n) {
            food -= n;
        }
    }

    public void addition() {//метод добавления еды в тарелку
        food += 100;
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}

class Cat {
    String name;
    int appetite;


    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        if (appetite > plate.food) {
            System.out.println("not enough food, the cat did not eat");
            System.out.println("add food to the plate");
            plate.addition();
        }else {
            plate.decreaseFood(appetite);
        }
    }

    public Boolean isSatiety(int food) {
        return appetite <= food;
    }

    @Override
    public String toString() {
        return "name:" + name;
    }
}