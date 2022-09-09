package draft.J2Leson4.javafxcontroller;
//класс для определения метода, некоторого элемента управления

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class JavaFXControllerController {

    @FXML
    private Button btn;//объяление кнопки

    //установка для кнопки
    @FXML
    private void click(ActionEvent event){
        btn.setText("You've clicked");
    }
}
