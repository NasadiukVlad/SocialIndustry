package nyft.diploma.controller.edit_data;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import nyft.diploma.controller.DisplayController;

/**
 * Created by Vladyslav.Nasadiuk on 17.05.2016.
 */
public class EditDealsController {
    @FXML
    Button toMenuButton = new Button();
    private DisplayController displayController = new DisplayController();


    public void goToMenu() {
        displayController.viewFXML(toMenuButton, "/fxml/mainMenu.fxml");
    }
}
