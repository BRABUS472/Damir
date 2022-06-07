package draft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Random;

public class TicTacToeGraphic extends JFrame {

final String TITLE_OF_PROGRAM = "Tic Tac Toe";
final int WINDOWS_SIZE = 330;
final int WINDOWS_DX = 7;
final int WINDOWS_DY = 55;
final int FIELD_SIZE = 3;
final  int CELL_SIZE = WINDOWS_SIZE/FIELD_SIZE;
final String BTN_INIT = "New Game";
final String BTN_EXIT = "Exit";

Panel panel = new Panel();
Field field = new Field(FIELD_SIZE, CELL_SIZE);
Human human = new Human (field.getHumanDot());
AI ai = new AI(field.getAIDot());

    public static void main(String[] args) {
        new TicTacToeGraphic();
    }
    TicTacToeGraphic(){
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOWS_SIZE+WINDOWS_DX,WINDOWS_SIZE+WINDOWS_DY);
        setLocationRelativeTo(null);//окно в центре, (null)-в центре экрана
        setResizable(false);//запрет изменения ока


        panel.setBackground(Color.white);//цвет фона окна
        panel.addMouseListener(new MouseAdapter() {//считывание положение мыши
            @Override
            public void mouseReleased(MouseEvent e){//метод запускается при отпускание мыши (метод Released)
                super.mouseReleased(e);
                System.out.println(e.getX()+":"+e.getY());//вывод координат по X и Y
                human.turn(e.getX()/CELL_SIZE, e.getY()/CELL_SIZE, field, ai);
                panel.repaint();
                if (field.isGameOver())
                    JOptionPane.showMessageDialog(
                    TicTacToeGraphic.this, field.getGameOverMsg());

            }
        });

        JButton init = new JButton(BTN_INIT);//создание кнопок NEW GAME
        init.addActionListener(e ->{ //лямбда выражение
            field.init();
            panel.repaint();//метод обнуляет все ходы, начинает игры заново
        });
        JButton exit = new JButton(BTN_EXIT);//создание кнопок Exit
        exit.addActionListener(new ActionListener() {//Выход из приложения через кнопку EXIT
            @Override
            public void actionPerformed(ActionEvent e) {
             System.exit(0);
            }
        });

        JPanel panelBtn = new JPanel(); //создаем панель
        panelBtn.setLayout(new GridLayout());//ратягивание клавиш на панель
        panelBtn.add(init);//добавляем кнопки на панель
        panelBtn.add(exit);

        add(panelBtn, BorderLayout.SOUTH);//добавляем панель с кнопками внизу
        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }
    class Panel extends JPanel{
        @Override
        public void paint(Graphics g){
            super.paint(g);
            field.paint(g);
        }
        }
    }


class AI {
    Random random = new Random();
    private final char DOT;

    AI(char ch) { DOT = ch; }
    void turn(Field field) {
        int x, y;
        do {
            x = random.nextInt(field.getSize());
            y = random.nextInt(field.getSize());
        } while (!field.isCellValid(x, y));
        field.setDot(x, y, DOT);
    }
}


class Field {
    private final int FIELD_SIZE;
    private final int CELL_SIZE;
    private final char HUMAN_DOT = 'x';
    private final char AI_DOT = 'o';
    private final char EMPTY_DOT = '.';
    private final String MSG_DRAW = "Draw, sorry...";
    private final String MSG_HUMAN_WON = "YOU WON!";
    private final String MSG_AI_WON = "AI WON!";
    private char[][] map;
    private String gameOverMsg;

    Field(int field_size, int cell_size) {
        FIELD_SIZE = field_size;
        CELL_SIZE = cell_size;
        map = new char[FIELD_SIZE][FIELD_SIZE];
        init();
    }

    void init() {
        for (int i = 0; i < FIELD_SIZE; i++)
            for (int j = 0; j < FIELD_SIZE; j++)
                map[i][j] = EMPTY_DOT;
        gameOverMsg = null;
    }

    int getSize() { return FIELD_SIZE; }

    char getHumanDot() { return HUMAN_DOT; }

    char getAIDot() { return AI_DOT; }

    boolean isGameOver() { return gameOverMsg != null; }

    String getGameOverMsg() { return gameOverMsg; }

    void setDot(int x, int y, char dot) { // set dot and check fill and win
        map[x][y] = dot;
        if (checkWin(HUMAN_DOT))
            gameOverMsg = MSG_HUMAN_WON;
        else if (checkWin(AI_DOT))
            gameOverMsg = MSG_AI_WON;
        else if (isMapFull())
            gameOverMsg = MSG_DRAW;
    }

    boolean isMapFull() {
        for (int i = 0; i < FIELD_SIZE; i++)
            for (int j = 0; j < FIELD_SIZE; j++)
                if (map[i][j] == EMPTY_DOT) return false;
        return true;
    }

    boolean checkWin(char dot) {
        // checking horizontals / verticals
        for (int i = 0; i < FIELD_SIZE; i++)
            if ((map[i][0] == dot && map[i][1] == dot && map[i][2] == dot) ||
                    (map[0][i] == dot && map[1][i] == dot && map[2][i] == dot))
                return true;
        // checking diagonals
        if ((map[0][0] == dot && map[1][1] == dot && map[2][2] == dot) ||
                (map[2][0] == dot && map[1][1] == dot && map[0][2] == dot))
            return true;
        return false;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x > FIELD_SIZE - 1 || y > FIELD_SIZE - 1) return false;
        if (map[x][y] == EMPTY_DOT) return true;
        return false;
    }

    public void paint(Graphics g) {
        g.setColor(Color.lightGray);
        for (int i = 1; i < FIELD_SIZE; i++) {//цикл прорисовывает серые рамки
            g.drawLine(0, i*CELL_SIZE, FIELD_SIZE*CELL_SIZE, i*CELL_SIZE);
            g.drawLine(i*CELL_SIZE, 0, i*CELL_SIZE, FIELD_SIZE*CELL_SIZE);
        }
        Graphics2D g2 = (Graphics2D) g; // use Graphics2D
        g2.setStroke(new BasicStroke(5));//размер линии при отрисовки
        for (int y = 0; y < FIELD_SIZE; y++) {
            for (int x = 0; x < FIELD_SIZE; x++) {
                if (map[x][y] == HUMAN_DOT) {
                    g.setColor(Color.blue);
                    g2.draw(new Line2D.Float(x*CELL_SIZE+CELL_SIZE/4, y*CELL_SIZE+CELL_SIZE/4, (x+1)*CELL_SIZE-CELL_SIZE/4, (y+1)*CELL_SIZE-CELL_SIZE/4));
                    g2.draw(new Line2D.Float(x*CELL_SIZE+CELL_SIZE/4, (y+1)*CELL_SIZE-CELL_SIZE/4, (x+1)*CELL_SIZE-CELL_SIZE/4, y*CELL_SIZE+CELL_SIZE/4));
                }
                if (map[x][y] == AI_DOT) {
                    g.setColor(Color.red);
                    g2.draw(new Ellipse2D.Float(x*CELL_SIZE+CELL_SIZE/4, y*CELL_SIZE+CELL_SIZE/4, CELL_SIZE/2, CELL_SIZE/2));
                }
            }
        }
    }
}

class Human {
    private final char DOT;

    Human(char ch) {DOT = ch; }

    void turn(int x, int y, Field field, AI ai) {
        if (field.isCellValid(x, y)) {
            if (!field.isGameOver()) field.setDot(x, y, DOT);
            if (!field.isGameOver()) ai.turn(field);
        }
    }
}