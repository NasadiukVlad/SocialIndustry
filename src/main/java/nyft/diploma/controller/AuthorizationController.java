package nyft.diploma.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import nyft.diploma.dao.DBConnect;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AuthorizationController implements Initializable {

    @FXML
    Button signInButton = new Button();

    @FXML
    TextField userLogin = new TextField();

    @FXML
    PasswordField userPassword = new PasswordField();



    public void signIn() throws SQLException {
        Connection c;
        String userRole = new String();

        c = DBConnect.connect();
        //SQL FOR SELECTING ALL OF CUSTOMER
        String SQL = "SELECT Role from Manager WHERE Login = '" + userLogin.getText() + "' AND Password = '" + userPassword.getText() + "'";
        //ResultSet
        ResultSet rs = c.createStatement().executeQuery(SQL);
        while(rs.next()){
            userRole = rs.getString("Role");
        }


        if(userRole.equals("trainee")) {
            try {

                Stage currentStage = (Stage) signInButton.getScene().getWindow();
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

                Stage currentStage = (Stage) signInButton.getScene().getWindow();
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

                Stage currentStage = (Stage) signInButton.getScene().getWindow();
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

    public void initialize(URL location, ResourceBundle resources) {

    }
}
