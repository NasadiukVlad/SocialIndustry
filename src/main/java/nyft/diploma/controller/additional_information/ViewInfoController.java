package nyft.diploma.controller.additional_information;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import nyft.diploma.controller.DisplayController;

/**
 * Created by Vlad on 22.05.2016.
 */
public class ViewInfoController {

    @FXML
    private Button toMenuButton = new Button();
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


}
