/*Создать окно для клиентской части чата: большое текстовое поле для отображения переписки
в центре окна. Однострочное текстовое поле для ввода сообщений и кнопка для отсылки
сообщений на нижней панели. Сообщение должно отсылаться либо по нажатию кнопки на
форме, либо по нажатию кнопки Enter. При «отсылке» сообщение перекидывается из нижнего
поля в центральное.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class home_work_2_4 {
    public static void main(String[] args) {
        Window chat = new Chat();

    }

    static class Chat extends JFrame {
        public Chat() {
            setBounds(500, 500, 300, 300);
            setTitle("CHAT");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setLayout(null);
            JTextField field = new JTextField();
            field.setBounds(5, 220, 200, 30);
            add(field);
            JTextArea area = new JTextArea();
            area.setBounds(5, 5, 290, 200);
            add(area);
            JButton button = new JButton("Отпр.");
            button.setBounds(210, 220, 70, 30);
            add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Button pressed..." + field.getText());
                    area.append(field.getText() + "\n");
                    field.setText("");
                }
            });
            JTextField textField = new JTextField();
            add(textField);
            field.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Your message: " + field.getText());
                    area.append(field.getText() + "\n");
                    field.setText("");
                }
            });
            setVisible(true);
        }
    }
}
