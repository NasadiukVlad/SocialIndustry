package nyft.diploma.controller.info_data;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import nyft.diploma.controller.DisplayController;
import nyft.diploma.controller.additional_information.UserInstructionViewController;

/**
 * Created by Vladyslav.Nasadiuk on 17.05.2016.
 */
public class InfoAuthorizationController {
    @FXML
    Button toMenuButton = new Button();

    @FXML
    Button toInstructionButton = new Button();

    private DisplayController displayController = new DisplayController();

    String userRole = new String();

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }


    public void goToMenu(){
        displayController.viewMenuFXML(toMenuButton, userRole);
    }

    public void goToInstruction() {
        try {

            Stage currentStage = (Stage) toMenuButton.getScene().getWindow();
            currentStage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/userInstructionView.fxml"));

            Parent root1 = (Parent) fxmlLoader.load();

            UserInstructionViewController controller = fxmlLoader.<UserInstructionViewController>getController();
            controller.setUserRole(userRole);


            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
