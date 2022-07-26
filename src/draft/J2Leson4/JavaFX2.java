package draft.J2Leson4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFX2 extends Application {
    @Override
    public void start(Stage primaryStage){
        Button btn = new Button(); //создание кнопки

        btn.setText("Say 'Hello Word!'"); //установка надписи
        btn.setOnAction(new EventHandler<ActionEvent>() { //EventHandler<ActionEvent>()-событие при нажатии кнопки(Обработчик событий)

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello Word!");
            }
        });

        StackPane root = new StackPane();//cпец панель содержащая элементы
        root.getChildren().add(btn);//добавляем кнопку btn

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello word!");
        primaryStage.setScene(scene);//установка сцены
        primaryStage.setResizable(false);// Изменения размера окна
        primaryStage.show();
    }
}
