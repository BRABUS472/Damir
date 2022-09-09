package draft.J2Leson4;
/*Приложение JavaFX представляет собой класс, который унаследован от класса java.application.Application.

Объект этого класса проходит ря этапов жизненного цикла.
Все эти этапы представлены методами класса Application, которые вызываються автоматически средой Java.

●init():  инициализирует приложение до его запускаю
●start(Stage stage): здесь определяется графический интерфейс
●stop()вызывается после закрытия приложения

Основой для создания графического интерфейся в JavaFX является класс javafx.stage.Stage
Можно использовать множество объектов Stage, но ни один из них не является основным.
При запуске приложения основной объект Stage создается средой JavaFX и передает метод start():


Класс Stage унаследован от класса javafx.stage.Window, который определяет базовые возможности приложения:

●close(): закрывет объект Stage(на десктопах по сути закрывается окно)
●hide(): скрывает окно
●centerOnScreen(): располагает окно в центре экрана
●to Back(): перемещает коно на задний план
●to Front(): перемещает окно на передний план
●sizeToScene: устанавливает размеры окна с размерами содержимого объекта Scene
●show(): отображает окно
●getX(): возвращает х-координату окна
●getY(): возвращает y-координату окна
●getWidth(): возвращает ширину
●getHeight():возвращает высоту
●getScene(): возвращает объект Scene окна
и т.д.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.Group;

public class FirstFXApp extends Application {

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage){

        //установка надписи
        Text text = new Text("Hello from JavaFX");
        text.setLayoutY(100); //установка положения надписи по оси Y
        text.setLayoutX(100); //установка положения надписи по оси X

        Group group = new Group(text); //создание и установка группы элементов

        Scene scene = new Scene(group); //создание сцены
        stage.setScene(scene);  //уставновка сцены объекта Stage
        stage.setTitle("First Application");
        stage.setWidth(300);
        stage.setHeight(300);
        stage.show();
    }
    }
