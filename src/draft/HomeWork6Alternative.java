package draft;

public class HomeWork6Alternative {
    public static void main(String[] args) {
        Animal[] animals = {new Cat(200,2,0),
                            new Dog(500,0.5f,10)};
        for (Animal animal : animals)
            System.out.println(
                    animal.getClass().getName()+
                            "\nrun: "+animal.run(200)+
                            "\njump: "+animal.jump(1.5f)+
                            "\nswim: "+animal.swim(5));
    }
}
class Cat extends AnimalImpl {
    Cat(int run_limit, float jump_limit, int swim_limit) {
        super(run_limit, jump_limit, swim_limit);
    }

    @Override
    public boolean swim(int distance) {
        return false;//cat cannot swim
    }
}
class Dog extends AnimalImpl {
    Dog(int run_limit, float jump_limit, int swim_limit) {
        super(run_limit, jump_limit, swim_limit);
    }
}
interface Animal {
    boolean run(int distance);
    boolean jump(float height);
    boolean swim(int distance);
}

abstract class AnimalImpl implements Animal {
    protected int run_limit;
    protected float jump_limit;
    protected int swim_limit;

    AnimalImpl(int run_limit, float jump_limit, int swim_limit) {
        this.run_limit = run_limit;
        this.jump_limit = jump_limit;
        this.swim_limit = swim_limit;
    }

    public boolean run(int distance) {
        return distance <= run_limit;
    }
    public boolean jump(float height){
        return height<=jump_limit;
    }
    public boolean swim(int distance){
        return distance<=swim_limit;
    }
}