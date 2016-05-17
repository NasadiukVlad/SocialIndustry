package nyft.diploma.controller.additional_information;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.stage.Stage;
import nyft.diploma.controller.DisplayController;

/**
 * Created by Vladyslav.Nasadiuk on 16.05.2016.
 */
public class UserInstructionViewController {

    @FXML
    Button toMenuButton = new Button();
    DisplayController displayController = new DisplayController();

    @FXML
    Button authorizationInfoButton = new Button();

    @FXML
    Button technicalSupportInfoButton = new Button();

    public void goToMenu() {
        displayController.viewFXML(toMenuButton, "/fxml/mainMenu.fxml");
    }

    public void viewAuthorizationInstruction()  {
        displayController.viewFXML(authorizationInfoButton, "/fxml/infoAuthorization.fxml" );
    }

    public void viewTechnicalSupportInstruction()  {
        displayController.viewFXML(authorizationInfoButton, "/fxml/infoTechnicalSupport.fxml" );
    }
}
