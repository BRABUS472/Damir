package draft.J3Lesson3;


import java.io.*;

public class Serializable1 {

    public static void main(String[] args) {


        //сериализация
        Students students = new Students(1, "Bob");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/draft/J3Lesson3/41/stud.ser"));//расширение можно выбрать другое
            oos.writeObject(students);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //десериализация
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/draft/J3Lesson3/41/stud.ser"));
            Students s2 = (Students) ois.readObject();
            ois.close();
            s2.info();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    static class Students implements Serializable {


        int id;
        String name;

        public Students(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public void info() {
            System.out.println(id + " " + name);
        }
    }
}
