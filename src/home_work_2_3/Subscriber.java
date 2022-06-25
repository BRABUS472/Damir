package home_work_2_3;

public class Subscriber {
    private int number;
    private String name;

    public String getName()
    {
        return this.name;
    }
    public int getNumber()
    {
        return this.number;
    }

    public Subscriber(int number, String name){
        this.name = name;
        this.number = number;
    }
}
