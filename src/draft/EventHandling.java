package draft;

import javax.swing.*;
import java.awt.event.*;

public class EventHandling {
    public static void main(String[] args) {
      //Window MyWindow = new MyWindow();
      //Window MyWindowEnter = new MyWindowEnter();
      //Window MyWindowMouse = new MyWindowMouse();
     new MyWindowClose();
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

//Чтобы выполнить какое-либо действие при закрытии окна, необходимо к объекту типа JFrame
//добавить WindowListener. В примере выше ссылка на объект отсутствует, так как метод прописан в
//конструкторе класса, наследуемого от JFrame.

class MyWindowClose extends JFrame{
        public MyWindowClose(){
            setBounds(500,500,300,120);
            setTitle("Window close");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.out.println("Window close");
                }
            });
            setVisible(true);
        }
}

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