package home_work_2_1;/*1.Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти
классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в
консоль).
2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники
должны выполнять соответствующие действия (бежать или прыгать), результат выполнения
печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти
этот набор препятствий.
4. * У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения
на бег и прыжки. Если участник не смог пройти одно из препятствий, то дальше по списку он
препятствий не идет.
*/


public class home_work_2_1 {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Cat1", 100, 20),
                new Cat("Cat2", 150, 30),
                new Cat("Cat3", 300, 15)
        };
        Human[] humans = {
                new Human("Human1", 200, 40),
                new Human("Human2", 450, 20),
                new Human("Human3", 500, 55)
        };

        Robot[] robots = {
                new Robot("Robot1", 100, 10),
                new Robot("Robot2", 150, 70),
                new Robot("Robot3", 700, 200)
        };
        Treadmill treadmill = new Treadmill(200);
        Wall wall = new Wall(10);


        getListResult(cats, treadmill, wall);
        getListResult(humans, treadmill, wall);
        getListResult(robots, treadmill, wall);

    }

    public static void getListResult(Participant[] participants, Treadmill treadmill, Wall wall) {
        for (Participant participant : participants) {
            getResult(participant, treadmill, wall);
        }

    }

    public static void getResult(Participant participant, Treadmill treadmill, Wall wall) {
        System.out.println(participant + " " + participant.start_run() + ", результат: " + treadmill.run(participant));
        if (!treadmill.run(participant)) {
            System.out.println("участник не смог пройти припятсвие, участник снят");
            return;
        }
        System.out.println(participant + " " + participant.start_jump() + " , результат: " + wall.jump(participant));

    }
}


class Cat implements Participant {

    private String name;
    private int run;
    private int jump;

    Cat(String name, int run, int jump) {
        this.name = name;
        this.run = run;
        this.jump = jump;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getRun() {
        return run;
    }

    @Override
    public int getJump() {
        return jump;
    }

    public String start_run() {
        return "Кот побежал";
    }

    public String start_jump() {
        return "Кот прыгнул";
    }

    @Override
    public String toString() {
        return "name:" + name;
    }
}

class Human implements Participant {

    private String name;
    private int run;
    private int jump;

    Human(String name, int run, int jump) {
        this.name = name;
        this.run = run;
        this.jump = jump;
    }

    String getName() {
        return name;
    }

    @Override
    public int getRun() {
        return run;
    }

    @Override
    public int getJump() {
        return jump;
    }

    public String start_run() {
        return "Человек побежал";
    }

    public String start_jump() {
        return "Человек прыгнул";
    }

    @Override
    public String toString() {
        return "name:" + name;
    }
}

class Robot implements Participant {

    private String name;
    private int run;
    private int jump;

    Robot(String name, int run, int jump) {
        this.name = name;
        this.run = run;
        this.jump = jump;
    }

    String getName() {
        return name;
    }

    @Override
    public int getRun() {
        return run;
    }

    @Override
    public int getJump() {
        return jump;
    }

    public String start_run() {
        return "Робот побежал";
    }

    public String start_jump() {
        return "Робот прыгнул";
    }

    @Override
    public String toString() {
        return "name:" + name;
    }
}

class Treadmill {
    private int distance;

    Treadmill(int distance) {
        this.distance = distance;
    }

    public Boolean run(Participant participant) {
        return participant.getRun() >= distance;
    }
}

class Wall {
    private int height;

    Wall(int height) {
        this.height = height;
    }

    public Boolean jump(Participant participant) {
        return participant.getJump() >= height;
    }

}
