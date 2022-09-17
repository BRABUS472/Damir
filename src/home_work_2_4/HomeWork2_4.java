package home_work_2_4;/*Создать окно для клиентской части чата: большое текстовое поле для отображения переписки
в центре окна. Однострочное текстовое поле для ввода сообщений и кнопка для отсылки
сообщений на нижней панели. Сообщение должно отсылаться либо по нажатию кнопки на
форме, либо по нажатию кнопки Enter. При «отсылке» сообщение перекидывается из нижнего
поля в центральное.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeWork2_4 {
    public static void main(String[] args) {
        Window chat = new Chat();
    }
}

class Chat extends JFrame {
    private static final String TITLE = "CHAT";
    private static final String SEND = "Отпр.";

    public Chat() {
        setBounds(500, 500, 300, 300);
        this.setResizable(false);
        setTitle(TITLE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        JTextArea area = createArea();
        JScrollPane pane = createPane(area);
        JTextField field = createField(area);
        JButton button = createButton(new ClickListener() {
            @Override
            public void onClick() {
                actionChat(field, area);
            }
        });
        setVisible(true);
        add(field);
        add(button);
        add(pane);
    }

    public JTextArea createArea() {
        JTextArea area = new JTextArea();
        area.setEditable(false);
        return area;
    }

    public JScrollPane createPane(JTextArea area) {
        JScrollPane pane = new JScrollPane(area);
        pane.setBounds(5, 5, 290, 200);
        return pane;
    }

    public JTextField createField(JTextArea area) {
        JTextField field = new JTextField();
        field.setBounds(5, 220, 200, 30);
        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionChat(field, area);
            }
        });
        return field;
    }

    interface ClickListener {
        public void onClick();
    }

    public JButton createButton(ClickListener clickListener) {
        JButton button = new JButton(SEND);
        button.setBounds(210, 220, 70, 30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickListener.onClick();
            }
        });
        return button;
    }

    public void actionChat(JTextField field, JTextArea area) {
        String text = field.getText();
        field.setText("");
        while (text.startsWith(" ")) {
            text = text.replaceFirst(" ", "");
        }
        if (text.equals("")) return;
        area.append(text + "\n");
    }
}