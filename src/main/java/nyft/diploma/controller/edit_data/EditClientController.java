package nyft.diploma.controller.edit_data;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.ResourceBundle;

/**
 * Created by Vladyslav.Nasadiuk on 16.05.2016.
 */
public class EditClientController implements Initializable {

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

    @FXML
    private Button addItemButton = new Button();

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

    public void edit() {

        editData = tableView.getSelectionModel().getSelectedItem().toString();
        System.out.println(editData);
        char arr[] = editData.toCharArray();
        editData = editData.copyValueOf(arr, 1, arr.length - 2);
        System.out.println(editData);
        dataArray = editData.split(",");
        System.out.println(Arrays.toString(dataArray));
        System.out.println(dataArray[0] +"  "+ dataArray[1]);
        addInitialsField.setText(dataArray[1]);
        addMobileField.setText(dataArray[2]);
        addAdressField.setText(dataArray[3]);
        addPasportField.setText(dataArray[4]);
        addAppartmentCode.setText(dataArray[5]);

    }

    public void update() {
        Connection connection;
        try {
            connection = DBConnect.connect();
            String SQL = "UPDATE Client SET Initials = '" + addInitialsField.getText() + "', Mobile_phone = '" + addMobileField.getText() + "', Adress = '" + addAdressField.getText() + "', Passport_serial = '" + addPasportField.getText() + "', Appartment_code = '" + addAppartmentCode.getText() + "' WHERE Client_code = '" + dataArray[0] + "'";


            stmt = connection.createStatement();
            stmt.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /*INSERT INTO Customers (CustomerName, ContactName, Address, City, PostalCode, Country)
    VALUES ('Cardinal','Tom B. Erichsen','Skagen 21','Stavanger','4006','Norway');*/

    public void addNewItem() {
        Connection connection;
        try {
            connection = DBConnect.connect();
            String SQL = "Insert INTO Client(Initials, Mobile_phone, Adress, Passport_serial, Appartment_code) VALUES ('" + addInitialsField.getText() + "','" + addMobileField.getText() + "','" + addAdressField.getText() + "','" + addPasportField.getText() + "','" + addAppartmentCode.getText() + "');" ;

            stmt = connection.createStatement();
            stmt.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





}
