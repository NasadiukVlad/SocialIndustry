package nyft.diploma.controller.additional_information;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.stage.Stage;
import nyft.diploma.controller.DisplayController;
import nyft.diploma.controller.MainMenuController;
import nyft.diploma.controller.info_data.InfoAuthorizationController;
import nyft.diploma.controller.info_data.InfoTechnicalSupportController;
import nyft.diploma.dao.DBConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public void viewAuthorizationInstruction()  {
        try {

            Stage currentStage = (Stage) authorizationInfoButton.getScene().getWindow();
            currentStage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/infoAuthorization.fxml"));

            Parent root1 = (Parent) fxmlLoader.load();

            InfoAuthorizationController controller = fxmlLoader.<InfoAuthorizationController>getController();
            controller.setUserRole(userRole);


            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
      //  displayController.viewFXML(authorizationInfoButton, "/fxml/infoAuthorization.fxml" );
    }

    public void viewTechnicalSupportInstruction()  {
        try {

            Stage currentStage = (Stage) authorizationInfoButton.getScene().getWindow();
            currentStage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/infoTechnicalSupport.fxml"));

            Parent root1 = (Parent) fxmlLoader.load();

            InfoTechnicalSupportController controller = fxmlLoader.<InfoTechnicalSupportController>getController();
            controller.setUserRole(userRole);


            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewViewInfo() {
        try {
            Stage currentStage = (Stage) authorizationInfoButton.getScene().getWindow();
            currentStage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/viewInfo.fxml"));

            Parent root1 = (Parent) fxmlLoader.load();

            ViewInfoController controller = fxmlLoader.<ViewInfoController>getController();
            controller.setUserRole(userRole);


            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //  displayController.viewFXML(authorizationInfoButton, "/fxml/viewInfo.fxml" );
    }

    public void viewEditInfo()  {
        try {
            Stage currentStage = (Stage) authorizationInfoButton.getScene().getWindow();
            currentStage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/editInfo.fxml"));

            Parent root1 = (Parent) fxmlLoader.load();

            EditInfoController controller = fxmlLoader.<EditInfoController>getController();
            controller.setUserRole(userRole);


            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
       // displayController.viewFXML(authorizationInfoButton, "/fxml/editInfo.fxml" );
    }
}
