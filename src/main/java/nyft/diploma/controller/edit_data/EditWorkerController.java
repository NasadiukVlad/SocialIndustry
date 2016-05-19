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
public class EditWorkerController implements Initializable {
    private ObservableList<ObservableList> data;

    @FXML
    private TextField searchInput = new TextField();

    @FXML
    private TextField addInitialsField = new TextField();

    @FXML
    private TextField addExperienceField = new TextField();

    @FXML
    private TextField addSuccessfulDealsField = new TextField();

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
            String SQL = "SELECT * from Manager";
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

    public void searchByInitials() {

        Connection c;
        String managerInitials = searchInput.getText();
        data = FXCollections.observableArrayList();
        try {
            c = DBConnect.connect();
            //SQL FOR SELECTING ALL OF CUSTOMER
            String SQL = "SELECT * from Manager WHERE Initials = '" + managerInitials + "'";
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
        System.out.println(editData);
        char arr[] = editData.toCharArray();
        editData = editData.copyValueOf(arr, 1, arr.length - 2);
        System.out.println(editData);
        dataArray = editData.split(",");
        System.out.println(Arrays.toString(dataArray));
        System.out.println(dataArray[0] +"  "+ dataArray[1]);
        addInitialsField.setText(dataArray[1]);
        addExperienceField.setText(dataArray[2]);
        addSuccessfulDealsField.setText(dataArray[3]);
        /*String[] ary = tableView.getSelectionModel().getSelectedItem().split("");
        System.out.println(pos.getRow());
*/
    }

    public void update() {
        Connection connection;
        try {
            connection = DBConnect.connect();
            String SQL = "UPDATE Manager SET Initials = '" + addInitialsField.getText() + "', Experience = '" + addExperienceField.getText() + "', Successful_deals = '" + addSuccessfulDealsField.getText() + "' WHERE Manager_code = '" + dataArray[0] + "'";
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

        //  data.update(addInitialsField.getText(), addSuccessfulDealsField.getText(), addExperienceField.getText(), addPasportField.getText(), addAppartmentCode.getText());
    }

    public void addNewItem() {
        Connection connection;
        try {
            connection = DBConnect.connect();
            String SQL = "Insert INTO Manager(Initials, Experience, Successful_deals) VALUES ('" + addInitialsField.getText() + "','" + addExperienceField.getText() + "','" + addSuccessfulDealsField.getText() + "');" ;

            stmt = connection.createStatement();
            stmt.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
