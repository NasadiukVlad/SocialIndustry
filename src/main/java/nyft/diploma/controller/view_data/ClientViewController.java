package nyft.diploma.controller.view_data;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.Callback;
import nyft.diploma.controller.DisplayController;
import nyft.diploma.dao.DBConnect;

import java.net.URL;
import java.sql.*;
import java.util.Arrays;
import java.util.ResourceBundle;

/**
 * Created by Vlad on 14.05.2016.
 */
public class ClientViewController implements Initializable {

    private ObservableList<ObservableList> data;

    @FXML
    private TextField clientName = new TextField();

    @FXML
    private TextField addInitialsField = new TextField();

    @FXML
    private TextField addMobileField = new TextField();

    @FXML
    private TextField addAdressField = new TextField();

    @FXML
    private TextField addPasportField = new TextField();

    @FXML
    private TextField addAppartmentCode = new TextField();

    @FXML
    private TableView tableView = new TableView();

    @FXML
    private Button toMenuButton = new Button();

    @FXML
    private Button addButton = new Button();

    @FXML
    private RadioButton searchByInitialsRb = new RadioButton();

    @FXML
    private RadioButton searchByAdressRb = new RadioButton();

    @FXML
    private RadioButton searchByAppartmentRb = new RadioButton();

    private DisplayController displayController = new DisplayController();
    private String editData = new String();
    private String dataArray[];
    Statement stmt = null;

    public void buildData() {

    }

    ToggleGroup group = new ToggleGroup();

    public void initialize(URL location, ResourceBundle resources) {
        tableView.setEditable(true);
        searchByInitialsRb.setToggleGroup(group);
        searchByAdressRb.setToggleGroup(group);
        searchByAppartmentRb.setToggleGroup(group);
        searchByInitialsRb.setSelected(true);

        Connection c;
        data = FXCollections.observableArrayList();
        try {
            c = DBConnect.connect();
            //SQL FOR SELECTING ALL OF CUSTOMER
            String SQL = "SELECT * from Client";
            //ResultSet
            ResultSet rs = c.createStatement().executeQuery(SQL);

            /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }

                });

                tableView.getColumns().addAll(col);
                System.out.println("Column [" + i + "] ");
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while (rs.next()) {
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added " + row);
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            tableView.setItems(data);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }

    public void goToMenu() {
        displayController.viewFXML(toMenuButton, "/fxml/mainMenu.fxml");
}

    public void searhByUser() {
        if (searchByInitialsRb.isSelected()) {
            Connection c;
            String userPIB = clientName.getText();
            data = FXCollections.observableArrayList();
            try {
                c = DBConnect.connect();
                //SQL FOR SELECTING ALL OF CUSTOMER
                String SQL = "SELECT * from Client WHERE Initials = '" + userPIB + "'";
                //ResultSet
                ResultSet rs = c.createStatement().executeQuery(SQL);

                /**********************************
                 * TABLE COLUMN ADDED DYNAMICALLY *
                 **********************************/
                for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                    //We are using non property style for making dynamic table
                    final int j = i;
                    TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                    col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                        public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                            return new SimpleStringProperty(param.getValue().get(j).toString());
                        }
                    });

                    tableView.getColumns().addAll(col);
                    System.out.println("Column [" + i + "] ");
                    col.setCellFactory(TextFieldTableCell.forTableColumn());
                    tableView.setEditable(true);

                }

                /********************************
                 * Data added to ObservableList *
                 ********************************/
                while (rs.next()) {
                    //Iterate Row
                    ObservableList<String> row = FXCollections.observableArrayList();
                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                        //Iterate Column
                        row.add(rs.getString(i));
                    }
                    System.out.println("Row [1] added " + row);
                    data.add(row);

                }

                //FINALLY ADDED TO TableView
                tableView.setItems(data);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error on Building Data");
            }
        }
    }

    public void searhByAdress() {
        if (searchByAdressRb.isSelected()) {
            Connection c;
            String userPIB = clientName.getText();
            data = FXCollections.observableArrayList();
            try {
                c = DBConnect.connect();
                //SQL FOR SELECTING ALL OF CUSTOMER
                String SQL = "SELECT * from Client WHERE Adress = '" + clientName.getText() + "'";
                //ResultSet
                ResultSet rs = c.createStatement().executeQuery(SQL);

                /**********************************
                 * TABLE COLUMN ADDED DYNAMICALLY *
                 **********************************/
                for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                    //We are using non property style for making dynamic table
                    final int j = i;
                    TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                    col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                        public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                            return new SimpleStringProperty(param.getValue().get(j).toString());
                        }
                    });

                    tableView.getColumns().addAll(col);
                    System.out.println("Column [" + i + "] ");
                    col.setCellFactory(TextFieldTableCell.forTableColumn());
                    tableView.setEditable(true);

                }

                /********************************
                 * Data added to ObservableList *
                 ********************************/
                while (rs.next()) {
                    //Iterate Row
                    ObservableList<String> row = FXCollections.observableArrayList();
                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                        //Iterate Column
                        row.add(rs.getString(i));
                    }
                    System.out.println("Row [1] added " + row);
                    data.add(row);

                }

                //FINALLY ADDED TO TableView
                tableView.setItems(data);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error on Building Data");
            }
        }
    }

    public void searhByAppartment() {
        if (searchByAppartmentRb.isSelected()) {
            Connection c;
            String userPIB = clientName.getText();
            data = FXCollections.observableArrayList();
            try {
                c = DBConnect.connect();
                //SQL FOR SELECTING ALL OF CUSTOMER
                String SQL = "SELECT * from Client WHERE Appartment_code = '" + clientName.getText() + "'";
                //ResultSet
                ResultSet rs = c.createStatement().executeQuery(SQL);

                /**********************************
                 * TABLE COLUMN ADDED DYNAMICALLY *
                 **********************************/
                for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                    //We are using non property style for making dynamic table
                    final int j = i;
                    TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                    col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                        public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                            return new SimpleStringProperty(param.getValue().get(j).toString());
                        }
                    });

                    tableView.getColumns().addAll(col);
                    System.out.println("Column [" + i + "] ");
                    col.setCellFactory(TextFieldTableCell.forTableColumn());
                    tableView.setEditable(true);

                }

                /********************************
                 * Data added to ObservableList *
                 ********************************/
                while (rs.next()) {
                    //Iterate Row
                    ObservableList<String> row = FXCollections.observableArrayList();
                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                        //Iterate Column
                        row.add(rs.getString(i));
                    }
                    System.out.println("Row [1] added " + row);
                    data.add(row);

                }

                //FINALLY ADDED TO TableView
                tableView.setItems(data);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error on Building Data");
            }
        }
    }


    public void selectSearch() {
        if (searchByInitialsRb.isSelected()) {
            searhByUser();
        }
        if (searchByAppartmentRb.isSelected()) {
            searhByAppartment();
        }
        if (searchByAdressRb.isSelected()) {
            searhByAdress();
        }
    }

}