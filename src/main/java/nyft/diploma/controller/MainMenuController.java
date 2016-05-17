package nyft.diploma.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Vlad on 08.05.2016.
 */
public class MainMenuController implements Initializable {

    @FXML
    Button viewWorkerButton = new Button();

    @FXML
    Button userInstructionButton = new Button();

    @FXML
    Button technicalSupportButton = new Button();

    @FXML
    Button editUserTableButton = new Button();

    @FXML
    Button editWorkersTableButton = new Button();

    @FXML
    Button editAppartmentsTableButton = new Button();

    @FXML
    Button editDealstTableButton = new Button();

    @FXML
    Button changeUserButton = new Button();

    private DisplayController displayController = new DisplayController();



    public void viewWorker()  {
        displayController.viewFXML(viewWorkerButton, "/fxml/workerView.fxml" );
    }

    public void viewClient() {
        displayController.viewFXML(viewWorkerButton, "/fxml/clientView.fxml" );
    }

    public void viewAppartment()  {
        displayController.viewFXML(viewWorkerButton, "/fxml/freeAppartmentView.fxml" );
    }

    public void viewDeals()  {
        displayController.viewFXML(viewWorkerButton, "/fxml/dealView.fxml" );
    }

    public void viewUserInstruction() {
        displayController.viewFXML(userInstructionButton, "/fxml/userInstructionView.fxml");
    }

    public void viewTechnicalSupport() {
        displayController.viewFXML(technicalSupportButton, "/fxml/technicalSupportView.fxml" );
    }

    public void viewEditUserTable() {
        displayController.viewFXML(editUserTableButton, "/fxml/editClient.fxml" );
    }

    public void viewEditWorkerTable() {
        displayController.viewFXML(editWorkersTableButton, "/fxml/editWorker.fxml" );
    }

    public void viewEditAppartmentTable() {
        displayController.viewFXML(editAppartmentsTableButton, "/fxml/editAppartment.fxml" );
    }

    public void viewEditDealsTable() {
        displayController.viewFXML(editDealstTableButton, "/fxml/editDeals.fxml" );
    }

    public void changeUser() {
        try {

            Stage currentStage = (Stage) changeUserButton.getScene().getWindow();
            currentStage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/authorization.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initialize(URL location, ResourceBundle resources) {

    }

    /**
     * Created by Vladyslav.Nasadiuk on 16.05.2016.
     */
    public static class TechnicalSupportViewController {
        @FXML
        private Button toMenuButton = new Button();

        public void goToMenu() {
            try {

                Stage currentStage = (Stage) toMenuButton.getScene().getWindow();
                currentStage.close();

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/mainMenu.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
