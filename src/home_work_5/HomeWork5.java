package home_work_5;

/**
 * Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
 * Конструктор класса должен заполнять эти поля при создании объекта;
 * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
 * Создать массив из 5 сотрудников:
 * Пример:
 * home_work_5.Person[] persArray = new home_work_5.Person[5]; // Вначале объявляем массив объектов
 * persArray[0] = new home_work_5.Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000,
 * 30); // потом для каждой ячейки массива задаем объект
 * persArray[1] = new home_work_5.Person(...);
 * ...
 * persArray[4] = new home_work_5.Person(...);
 * С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
 */

public class HomeWork5 {
    public static void main(String[] args) {
        Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        persArray[1] = new Person("Sidorov Victor", "Engineer", "sivictor@mail.ru", "89994355", 35000, 29);
        persArray[2] = new Person("Fedorov Maksim", "Director", "FeMaksim@gmail.com", "89333322", 20000, 49);
        persArray[3] = new Person("Demchenko Ilya", "Designer", "Nagibator333@gmail.com", "896555223", 56000, 35);
        persArray[4] = new Person("Shelkov Dmitryu", "Cleaner", "Shelmaks@gmail.com", "8966654", 25000, 57);

//        for (int i = 0; i < persArray.length; i++) {
//            System.out.println(persArray[i].getInformation(i,i+1));
//        }
        for (Person person : persArray) {
            person.printInformation();
        }
        System.out.println();
        for (Person a : persArray) {
            if (a.getAge() > 40)
                System.out.println(a.getInformation());
        }

    }
}


class Person {
    final private String fullName;
    final private String position;
    final private String email;
    final private String phone;
    final private int salary;
    final private int age;

    public Person(String fullName, String position, String email, String phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    String getFullName() {
        return fullName;
    }

    String getPosition() {
        return position;
    }

    String getEmail() {
        return email;
    }

    String getPhone() {
        return phone;
    }

    int getSalary() {
        return salary;
    }

    int getAge() {
        return age;
    }


    String getInformation(int a, int b) {
        int c = a + b;
        return getInformation() + ", c=" + c;

    }

    void printInformation() {
        System.out.println(getInformation());
    }


    String getInformation() {
        return "fullName=" + fullName + ", position=" + position + ", email=" + email + ", phone=" + phone + ", salary=" + salary + ", age=" + age;
    }
}


