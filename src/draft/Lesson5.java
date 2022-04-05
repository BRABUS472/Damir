package draft;

public class Lesson5 {
    public static void main(String args[]) {
        Cat2 cat = new Cat2("Murzik", "white", 3);
        cat.setAge(5);
        System.out.println(cat.name + " " + cat.color + " " + cat.getAge());
        System.out.println(cat.voice());

    }
}

class Cat2 {
    String name;
    String color;
    private int age;

    Cat2(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    int getAge() {
        return age;
    }

    void setAge(int age) {
        if (age > 0)
        this.age = age;
    }

    String voice() {
        return "meow";
    }
}