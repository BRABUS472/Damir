package draft.J3Lesson3;

import java.io.*;

public class Ser_DerSer {
    public static void main (String[] args) throws IOException, ClassNotFoundException {


        class Students  implements Serializable {
            int id;
            String name;


            public Students(int id, String name) {
                //super(10);
                this.id = id;
                this.name = name;
            }

            public void info() {
                System.out.println(id + " " + name);
            }
        }

        //сериализация
    Students students = new Students(1, "Bob");
   // Book book = new Book("book");
    //students.book = book;
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Damir/src/draft/J3Lesson3/stud1.ser"));
        oos.writeObject(students);
        oos.close();

        //десериализация
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Damir/src/draft/J3Lesson3/stud1.ser"));
    Students s2 = (Students)ois.readObject();
        ois.close();
        s2.info();

}
}


//class Book {
//    String title;
//
//    public Book(String title) {
//        this.title = title;
//    }
//}
//
//class Human implements Serializable {
//    public Human() {
//        System.out.println("default");
//    }
//
//    //    public Human(int n) {
////        System.out.println(n);
////    }
//}
//
//
//class Students extends Human implements Serializable {
//    int id;
//    String name;
//    //transient Book book;//исключение для десиреализации
//
//    public Students(int id, String name) {
//        //super(10);
//        this.id = id;
//        this.name = name;
//    }





