package draft;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Read_CSV {

    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Ivanov Ivan", "Engineer", "ivanov@mail.com", "2222222", 30000, 45),
                new Employee("Vasilev Vasil", "Lead Engineer", "vasil@mail.com", "3333", 40000, 20)
        };
        //Вывод всех сотрудников старше 40
        for (Employee employee : employees)
            if (employee.getAge() > 40) {
                System.out.println(employee);
            }

//Запись CSV файла на примере записи сотрудников (employee)
        try (FileWriter file = new FileWriter("employee.txt")) {
            for (Employee employee : employees)
                file.write(employee.getDataInCSV() + "\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
//Чтение всех линий с файла
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get("employee.txt"),
                    StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //Разбор файла
        int index = 0;
        employees = new Employee[lines.size()];
        for (String line : lines) {
            String[] field = line.split(",");
            employees[index] = new Employee(
                    field[0], field[1], field[2], field[3],
                    Integer.parseInt(field[4]), Integer.parseInt(field[5]));
            index++;
        }
    }
}

class Employee {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getDataInCSV() {
        return name + "," + position + "," + email + "," + phone + "," + salary + "," + age;
    }

    @Override
    public String toString() {//Переопределение метода toString
        return (name +
                "\n|Position:" + position +
                "\n|Email:" + email +
                "\n|Phone:" + phone +
                "\n|Salary:" + salary +
                "\n|Age:" + age);
    }
}

