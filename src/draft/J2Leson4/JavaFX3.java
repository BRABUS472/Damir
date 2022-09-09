package draft.J2Leson4;

import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class JavaFX3 extends Application {

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
    Label label = new Label("Hello");         //Текстова метка
    Button button = new Button("Button");     //Кнопка

        Group group = new Group(button);           //Вложенный узел.Помещаем button в group

        FlowPane root = new FlowPane(label, group); //Корневой узел  , group -содержит button
        Scene scene = new Scene(root,300, 300); //Создание Scene
        stage.setScene(scene);                               //установки Scene

        stage.setTitle("Hello javaFX");
        stage.show();
    }
    }
