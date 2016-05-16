package nyft.diploma.controller.edit_data;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import nyft.diploma.controller.DisplayController;

/**
 * Created by Vladyslav.Nasadiuk on 16.05.2016.
 */
public class EditClientController {
    @FXML
    Button toMenuButton = new Button();
    private DisplayController displayController = new DisplayController();


    public void goToMenu() {
        displayController.viewFXML(toMenuButton, "/fxml/mainMenu.fxml");
    }
}
