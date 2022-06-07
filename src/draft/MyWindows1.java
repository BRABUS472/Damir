package draft;
//● JFrame – окно приложения;
//● JButton – кнопка;
//● JLabel – надпись;
//● JTextField – однострочное текстовое поле;
//● JTextArea – многострочное текстовое поле;
//● JScrollPane – контейнер для пролистывания контента;
//● JMenuBar – верхнее меню программы;
//● JTable – таблица;
//● JRadioButton – RadioButton;
//● JCheckBox – CheckBox.

import javax.swing.*;
import java.awt.*;
//BorderLayout – располагает элементы «по сторонам света»
class MyWindow1 extends JFrame {
    public MyWindow1() {
        setTitle("Test Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);
        setVisible(true);
        JButton[] jbs = new JButton[5];
        for (int i = 0; i < 5; i++) {
            jbs[i] = new JButton("#" + i);
        }
        setLayout(new BorderLayout()); // выбор компоновщика элементов
        add(jbs[0], BorderLayout.EAST); // добавление кнопки на форму
        add(jbs[1], BorderLayout.WEST);
        add(jbs[2], BorderLayout.SOUTH);
        add(jbs[3], BorderLayout.NORTH);
        add(jbs[4], BorderLayout.CENTER);

    }
}
class MyWindow2 extends JFrame {
    public MyWindow2() {
        setTitle("Test Window2");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);
        JButton button = new JButton("Button 1 (Page Start)");
        add(button, BorderLayout.PAGE_START);
        button = new JButton("Button 2 (Center)");
        button.setPreferredSize(new Dimension(200, 100));
        add(button, BorderLayout.CENTER);
        button = new JButton("Button 3 (Line Start)");
        add(button, BorderLayout.LINE_START);
        button = new JButton("Long-Named Button 4 (Page END)");
        add(button, BorderLayout.PAGE_END);
        button = new JButton("5 (Line End)");
        add(button, BorderLayout.LINE_END);
        setVisible(true);
    }
}
//BoxLayout – располагает элементы в строку или столбец, в зависимости от используемой константы:
//BoxLayout.Y_AXIS для расположения элементов в столбец, BoxLayout.X_AXIS - в строку.
class MyWindow3 extends JFrame{
    public MyWindow3() {
        setBounds(800,50,500,300);
        setTitle("BoxLayoutDemo1");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton [] jbs = new JButton[10];
        setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
        for (int i =0; i< jbs.length; i++){
            jbs[i] = new JButton("#"+i);
            jbs[i].setAlignmentX(CENTER_ALIGNMENT);
            add(jbs[i]);
        }
        setVisible(true);
    }
}
class MyWindow4 extends JFrame{
    public MyWindow4() {
        setBounds(500,500,500,300);
        setTitle("BoxLayoutDemo2");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton [] jbs = new JButton[10];
        setLayout(new BoxLayout(getContentPane(),BoxLayout.X_AXIS));
        for (int i =0; i< jbs.length; i++){
            jbs[i] = new JButton("#"+i);
            jbs[i].setAlignmentX(CENTER_ALIGNMENT);
            add(jbs[i]);
        }
        setVisible(true);
    }
}
//FlowLayout – располагает элементы в одну строку, когда ширины строки становится недостаточно,
//переносит новые элементы на следующую
class MyWindow5 extends JFrame{
    public MyWindow5(){
        setBounds(500,500,400,300);
        setTitle("FlowLayoutDemo");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton[] jbs = new JButton[10];
        setLayout(new FlowLayout());
        for (int i = 0; i < jbs.length; i++) {
            jbs[i] = new JButton("#" + i);
            add(jbs[i]);
        }
        setVisible(true);
    }
}

//GridLayout-Элементы управления раскладываются по ячейкам таблицы, для которой задано количество строки и
//столбцов. Высота строк и ширина столбцов зависит от их количества и размеров формы, то есть
//вручную задать значения этих свойств нельзя.
class MyWindow6 extends JFrame {
    public MyWindow6() {
        setBounds(500,500,400,300);
        setTitle("GridLayoutDemo");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton[] jbs = new JButton[12];
        setLayout(new GridLayout(4, 3));
        for (int i = 0; i < jbs.length; i++) {
            jbs[i] = new JButton("#" + i);
            add(jbs[i]);
        }
        setVisible(true);
    }
}

//Отключение компоновщика элементов-Возможен сценарий ручной расстановки элементов путем указания их абсолютных координат. Для
//этого необходимо указать setLayout(null) и для каждого элемента указать его координаты и размеры
//с помощью метода setBounds().

class MyWindow7 extends JFrame{
public MyWindow7(){
    setBounds(500,500,300,300);
    setTitle("Manual GUI");
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setLayout(null);
    JTextField field = new JTextField();
    field.setBounds(20,20,120,32);
    add(field);
    JButton button= new JButton("Нажми сюда");
    button.setBounds(20,60,120,32);
    add(button);
    setVisible(true);
}
}

public class MyWindows1 {
    public static void main(String[] args) {
        Window myWindow1 = new MyWindow1();
        Window myWindow2 = new MyWindow2();
        Window myWindow3 = new MyWindow3();
        Window myWindow4 = new MyWindow4();
        Window myWindow5  =new MyWindow5();
        Window myWindow6  =new MyWindow6();
        Window myWindow7  =new MyWindow7();
    }
}