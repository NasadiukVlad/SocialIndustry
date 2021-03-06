package nyft.diploma.controller.edit_data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
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
 * Created by Vladyslav.Nasadiuk on 17.05.2016.
 */
public class EditSaledAppartmentController implements Initializable {
    private ObservableList<ObservableList> data;

    @FXML
    private TextField addAdressField = new TextField();

    @FXML
    private TextField addPriceField = new TextField();

    @FXML
    private TextField appartmentNumberField = new TextField();

    @FXML
    private TextField addAreaField = new TextField();

    @FXML
    private TextField addDeveloperCodeField = new TextField();

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
    private TextField searchInput = new TextField();

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
            String SQL = "SELECT * from Saled_appartment";
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

    public void searchByAdress() {

        Connection c;
        String appartmentAdress = searchInput.getText();
        data = FXCollections.observableArrayList();
        try {
            c = DBConnect.connect();
            //SQL FOR SELECTING ALL OF CUSTOMER
            String SQL = "SELECT * from Saled_appartment WHERE Adress = '" + appartmentAdress + "'";
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

    public void edit() {
        /*TablePosition pos = (TablePosition) tableView.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();*/

// Item here is the table view type:
        //     Item item = table.getItems().get(row);

        /*TableColumn col = pos.getTableColumn();*/

// this gives the value in the selected cell:
        /*String editData = (String) col.getCellObservableValue(tableView.getItems().get(row)).getValue();
        System.out.println(editData);*/
        editData = tableView.getSelectionModel().getSelectedItem().toString();
        char arr[] = editData.toCharArray();
        editData = editData.copyValueOf(arr, 1, arr.length - 2);
        dataArray = editData.split(",");
        System.out.println(Arrays.toString(dataArray));
        addAdressField.setText(dataArray[1]);
        addPriceField.setText(dataArray[2]);
        appartmentNumberField.setText(dataArray[3]);
        addAreaField.setText(dataArray[4]);
        addDeveloperCodeField.setText(dataArray[5]);
        /*String[] ary = tableView.getSelectionModel().getSelectedItem().split("");
        System.out.println(pos.getRow());
*/
    }

    public void update() {
        Connection connection;
        try {
            connection = DBConnect.connect();
            String SQL = "UPDATE Saled_appartment SET Adress = '" + addAdressField.getText() + "', Price = '" + addPriceField.getText() + "', Appartment_number = '" + appartmentNumberField.getText() + "', Area = '" + addAreaField.getText() + "', Developer_code = '" + addDeveloperCodeField.getText() + "' WHERE Appartment_code = '" + dataArray[0] + "'";
            //ResultSet
            // ResultSet rs = connection.createStatement().executeUpdate(SQL);
            /*PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.executeUpdate();*/

            stmt = connection.createStatement();
            stmt.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //SQL FOR SELECTING ALL OF CUSTOMER

        //  data.update(appartmentNumberField.getText(), appartmentNumberField.getText(), addPriceField.getText(), addAreaField.getText(), addDeveloperCodeField.getText());
    }

    public void addNewItem() {
        Connection connection;
        try {
            connection = DBConnect.connect();
            String SQL = "Insert INTO Saled_appartment (Adress, Price, Appartment_number, Area, Developer_code) VALUES ('" + addAdressField.getText() + "','" + addPriceField.getText() + "','" + appartmentNumberField.getText() + "','" + addAreaField.getText() + "','" + addDeveloperCodeField.getText() + "');" ;

            stmt = connection.createStatement();
            stmt.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
