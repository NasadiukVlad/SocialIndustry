package nyft.diploma.controller.info_data;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import nyft.diploma.controller.DisplayController;

/**
 * Created by Vladyslav.Nasadiuk on 17.05.2016.
 */
public class InfoAuthorizationController {
    @FXML
    Button toMenuButton = new Button();

    @FXML
    Button toInstructionButton = new Button();

    private DisplayController displayController = new DisplayController();

    public void goToMenu() {
        displayController.viewFXML(toMenuButton, "/fxml/mainMenu.fxml");
    }

    public void goToInstruction() {
        displayController.viewFXML(toMenuButton, "/fxml/userInstructionView.fxml");
    }
}
