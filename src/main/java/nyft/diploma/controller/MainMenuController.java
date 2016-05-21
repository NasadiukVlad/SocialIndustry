package nyft.diploma.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import nyft.diploma.report.db.ClientDataBeanMaker;
import nyft.diploma.report.db.ManagerDataBeanMaker;
import nyft.diploma.report.db.SaledAppartmentDataBeanMaker;
import nyft.diploma.report.model.ClientReport;
import nyft.diploma.report.model.ManagerReport;
import nyft.diploma.report.model.SaledAppartmentReport;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
        displayController.viewFXML(viewWorkerButton, "/fxml/saledAppartmentView.fxml");
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
        displayController.viewFXML(editAppartmentsTableButton, "/fxml/editSaledAppartment.fxml");
    }

    public void viewEditDealsTable() {
        displayController.viewFXML(editDealstTableButton, "/fxml/editDeals.fxml" );
    }

    public void viewTimeTrackingTable() {
        displayController.viewFXML(editDealstTableButton, "/fxml/timeTracking.fxml" );
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

    public void createManagerReport() throws Exception {
        InputStream inputStream = null;
        InputStream pin = null;
        try {
           /* inputStream = new FileInputStream("/jrxml/manager_report.jrxml");*/
            java.net.URL url = this.getClass().getResource("/jrxml/manager_report.jrxml");
            pin = new java.io.FileInputStream(url.getFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ManagerDataBeanMaker managerDataBeanMaker = new ManagerDataBeanMaker();
        ArrayList<ManagerReport> userRolesReports = managerDataBeanMaker.getDataBeanList();

        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(userRolesReports);

        Map parameters = new HashMap();

        JasperDesign jasperDesign = JRXmlLoader.load(pin);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, "manager_report.pdf");
        JasperExportManager.exportReportToHtmlFile(jasperPrint, "manager_report.html");
        JRXlsxExporter exporter = new JRXlsxExporter();
        exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, "manager_report.xlsx");
        exporter.exportReport();
        System.out.println("Completed");

    }

    public void createSaledAppartmentReport() throws Exception {
        InputStream inputStream = null;
        InputStream pin = null;
        try {
           /* inputStream = new FileInputStream("/jrxml/manager_report.jrxml");*/
            java.net.URL url = this.getClass().getResource("/jrxml/saled_appartment_report.jrxml");
            pin = new java.io.FileInputStream(url.getFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        SaledAppartmentDataBeanMaker saledAppartmentDataBeanMaker = new SaledAppartmentDataBeanMaker();
        ArrayList<SaledAppartmentReport> userRolesReports = saledAppartmentDataBeanMaker.getDataBeanList();

        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(userRolesReports);

        Map parameters = new HashMap();

        JasperDesign jasperDesign = JRXmlLoader.load(pin);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, "saled_appartment_report.pdf");
        JasperExportManager.exportReportToHtmlFile(jasperPrint, "saled_appartment_report.html");
        JRXlsxExporter exporter = new JRXlsxExporter();
        exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, "saled_appartment_report.xlsx");
        exporter.exportReport();
        System.out.println("Completed");
    }

    public void createClientReport() throws Exception {
        InputStream inputStream = null;
        InputStream pin = null;
        try {
           /* inputStream = new FileInputStream("/jrxml/manager_report.jrxml");*/
            java.net.URL url = this.getClass().getResource("/jrxml/client_report.jrxml");
            pin = new java.io.FileInputStream(url.getFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ClientDataBeanMaker clientDataBeanMaker = new ClientDataBeanMaker();
        ArrayList<ClientReport> userRolesReports = clientDataBeanMaker.getDataBeanList();

        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(userRolesReports);

        Map parameters = new HashMap();

        JasperDesign jasperDesign = JRXmlLoader.load(pin);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, "client_report.pdf");
        JasperExportManager.exportReportToHtmlFile(jasperPrint, "client_report.html");
        JRXlsxExporter exporter = new JRXlsxExporter();
        exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, "client_report.xlsx");
        exporter.exportReport();
        System.out.println("Completed");
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
