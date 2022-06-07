package home_work_2_1;
/*1.Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти
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

        IParticipant[] participants ={
                new Cat("Cat1", 100, 20),
                new Cat("Cat2", 150, 30),
                new Cat("Cat3", 300, 15),
                new Human("Human1", 200, 40),
                new Human("Human2", 450, 20),
                new Human("Human3", 500, 55),
                new Robot("Robot1", 100, 10),
                new Robot("Robot2", 150, 70),
                new Robot("Robot3", 700, 200)

        };
        ITrail[] trails = {
                new Treadmill(200),
                new Treadmill(300),
                new Treadmill(400),
                new Wall(10),
                new Wall(20),
                new Wall(30)
        };

      getResult(participants, trails);
    }


    public static void getResult(IParticipant[] participants, ITrail[] trails) {
        for (IParticipant participant : participants) {
            for (ITrail trail: trails) {
                if(trail.check(participant)){
                        System.out.println(participant + " " + "результат: " + trail.check(participant));
                }else{
                    System.out.println(" Участник лох");
                }
            }
        }
    }
}



class Cat implements IParticipant {

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

class Human implements IParticipant {

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

class Robot implements IParticipant {

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

class Treadmill implements ITrail {
    private int distance;

    Treadmill(int distance) {
        this.distance = distance;
    }

    public Boolean run(IParticipant participant) {
        return participant.getRun() >= distance;
    }
    @Override
    public boolean check(IParticipant participant){
        System.out.print(participant.start_run());
       return participant.getRun()>=this.distance;
    }
}

class Wall implements ITrail {
    private int height;

    Wall(int height) {
        this.height = height;
    }

    public Boolean jump(IParticipant participant) {
        return participant.getJump() >= height;
    }
    @Override
    public boolean check(IParticipant participant){
        System.out.print(participant.start_jump());
        return participant.getJump()>=this.height;
    }


}
