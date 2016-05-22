package nyft.diploma.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import nyft.diploma.controller.additional_information.UserInstructionViewController;

/**
 * Created by Vladyslav.Nasadiuk on 16.05.2016.
 */
public final class DisplayController {

    public void viewFXML(Button button, String fxmlPath) {
        try {

            Stage currentStage = (Stage) button.getScene().getWindow();
            currentStage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewMenuFXML(Button button, String userRole) {
        if(userRole.equals("trainee")) {
            try {

                Stage currentStage = (Stage) button.getScene().getWindow();
                currentStage.close();

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/mainMenuTrainee.fxml"));

                Parent root1 = (Parent) fxmlLoader.load();

                MainMenuController controller = fxmlLoader.<MainMenuController>getController();
                controller.setUserRole(userRole);


                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(userRole.equals("manager")) {
            try {

                Stage currentStage = (Stage) button.getScene().getWindow();
                currentStage.close();

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/mainMenu.fxml"));

                Parent root1 = (Parent) fxmlLoader.load();

                MainMenuController controller = fxmlLoader.<MainMenuController>getController();
                controller.setUserRole(userRole);

                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(userRole.equals("accountant")) {
            try {

                Stage currentStage = (Stage) button.getScene().getWindow();
                currentStage.close();

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/mainMenuAccountant.fxml"));

                Parent root1 = (Parent) fxmlLoader.load();

                MainMenuController controller = fxmlLoader.<MainMenuController>getController();
                controller.setUserRole(userRole);

                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void viewController(Button button, String userRole, String fxml, Class object) {

       /* try {
            Object obj = object.getClass();
            Stage currentStage = (Stage) button.getScene().getWindow();
            currentStage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));

            Parent root1 = (Parent) fxmlLoader.load();

            UserInstructionViewController controller = fxmlLoader.<object>getController();
            controller.setUserRole(userRole);


            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
