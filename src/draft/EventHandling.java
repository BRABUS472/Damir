package draft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EventHandling {
    public static void main(String[] args) {
      Window MyWindow = new MyWindow();
      Window MyWindowEnter = new MyWindowEnter();
      Window MyWindowMouse = new MyWindowMouse();
    }
}
//Обработка нажатие на button
class MyWindow extends JFrame {
    public MyWindow() {
        setTitle("Test Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);
        JButton button = new JButton("Button");
        add(button);
        button.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    System.out.println("Button pressed...");
                }
                });
        setVisible(true);
    }
}
//Обработка нажатия кнопки Enter в текстовом поле
class MyWindowEnter extends JFrame{
    public MyWindowEnter(){
        setBounds(600,600,400,300);
        setTitle("DemoEnter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JTextField field = new JTextField();
        add(field);
        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Your message: "+field.getText());
            }
        });
        setVisible(true);
    }
}
//Отслеживание кликов мыши по панели о определение координат клика
class MyWindowMouse extends JFrame{
    public MyWindowMouse(){
        setBounds(500,500,800,900);
        setTitle("Demo Mouse");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel pan = new JPanel();
        add(pan);
        pan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e){
                System.out.println("MousePosition: "+e.getX()+" "+e.getY());
            }
        });
        setVisible(true);
    }
}
