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
        catArr[0] = new Cat("Barsik", 40, false);
        catArr[1] = new Cat("Murzik", 50, false);
        catArr[2] = new Cat("Dusiy", 6, false);

        Plate plate = new Plate(100);
        plate.info();

        for (Cat cat : catArr) {
            System.out.println(cat.name +" satiety: " + cat.satiety(plate.food));
            cat.eat(plate);
            plate.info();
            plate.addition();
        }
        plate.info();
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
        } else
            notFood();
    }

    public void addition(){//метод добавления еды в тарелку
        if (food == 0){
            food += 100;
        }
    }

    public void notFood() {
        System.out.println("not enough food");
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}

class Cat {
    String name;
    int appetite;
    boolean satiety;

    public Cat(String name, int appetite, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;

    }

    public void eat(Plate plate) {
        plate.decreaseFood(appetite);
    }

    public Boolean satiety(int food) {
        return appetite <= food;
    }
    @Override
    public String toString() {
        return "name:"+name;
    }
}