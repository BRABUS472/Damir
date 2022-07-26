package draft.J2Leson4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFXML extends Application {

    public static void main(String[] args) {
        launch(args);
    }

 @Override
 public void start (Stage stage) throws Exception {

     Parent root = FXMLLoader.load(getClass().getResource("JavaFXML.fxml")); //добавляем кнопку через fxml
     Scene scene = new Scene(root);

     stage.setScene(scene);

     stage.setTitle("Hello javaFX");
     stage.setWidth(450);
     stage.setHeight(400);

     stage.show();
 }
}
