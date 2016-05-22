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
import nyft.diploma.controller.additional_information.TechnicalSupportViewController;
import nyft.diploma.controller.additional_information.TimeTrackingViewController;
import nyft.diploma.controller.additional_information.UserInstructionViewController;
import nyft.diploma.controller.edit_data.*;
import nyft.diploma.controller.view_data.*;
import nyft.diploma.report.db.*;
import nyft.diploma.report.model.*;

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

    String userRole = new String();

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    private DisplayController displayController = new DisplayController();



    public void viewWorker()  {
        try {

            Stage currentStage = (Stage) viewWorkerButton.getScene().getWindow();
            currentStage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/workerView.fxml"));

            Parent root1 = (Parent) fxmlLoader.load();

           WorkerViewController controller = fxmlLoader.<WorkerViewController>getController();
            controller.setUserRole(userRole);


            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
     //   displayController.viewFXML(viewWorkerButton, "/fxml/workerView.fxml" );
    }

    public void viewClient() {
        try {

            Stage currentStage = (Stage) viewWorkerButton.getScene().getWindow();
            currentStage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/clientView.fxml"));

            Parent root1 = (Parent) fxmlLoader.load();

            ClientViewController controller = fxmlLoader.<ClientViewController>getController();
            controller.setUserRole(userRole);


            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
      //  displayController.viewFXML(viewWorkerButton, "/fxml/clientView.fxml" );
    }

    public void viewAppartment()  {
        try {

            Stage currentStage = (Stage) viewWorkerButton.getScene().getWindow();
            currentStage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/saledAppartmentView.fxml"));

            Parent root1 = (Parent) fxmlLoader.load();

            SaledAppartmentViewController controller = fxmlLoader.<SaledAppartmentViewController>getController();
            controller.setUserRole(userRole);


            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
   //     displayController.viewFXML(viewWorkerButton, "/fxml/saledAppartmentView.fxml");
    }

    public void viewDeals()  {
        try {

            Stage currentStage = (Stage) viewWorkerButton.getScene().getWindow();
            currentStage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/dealView.fxml"));

            Parent root1 = (Parent) fxmlLoader.load();

            DealsBaseViewController controller = fxmlLoader.<DealsBaseViewController>getController();
            controller.setUserRole(userRole);


            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
       // displayController.viewFXML(viewWorkerButton, "/fxml/dealView.fxml" );
    }

    public void viewUserInstruction() {
            try {

                Stage currentStage = (Stage) userInstructionButton.getScene().getWindow();
                currentStage.close();

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/userInstructionView.fxml"));

                Parent root1 = (Parent) fxmlLoader.load();

                UserInstructionViewController controller = fxmlLoader.<UserInstructionViewController>getController();
                controller.setUserRole(userRole);


                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }

       // displayController.viewFXML(userInstructionButton, "/fxml/userInstructionView.fxml");
    }

    public void viewTechnicalSupport() {
        try {

            Stage currentStage = (Stage) technicalSupportButton.getScene().getWindow();
            currentStage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/technicalSupportView.fxml"));

            Parent root1 = (Parent) fxmlLoader.load();

            TechnicalSupportViewController controller = fxmlLoader.<TechnicalSupportViewController>getController();
            controller.setUserRole(userRole);


            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
  //      displayController.viewFXML(technicalSupportButton, "/fxml/technicalSupportView.fxml" );
    }

    public void viewEditUserTable() {
        try {

            Stage currentStage = (Stage) editUserTableButton.getScene().getWindow();
            currentStage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/editClient.fxml"));

            Parent root1 = (Parent) fxmlLoader.load();

            EditClientController controller = fxmlLoader.<EditClientController>getController();
            controller.setUserRole(userRole);


            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
       // displayController.viewFXML(editUserTableButton, "/fxml/editClient.fxml" );
    }

    public void viewEditWorkerTable() {
        try {

            Stage currentStage = (Stage) editWorkersTableButton.getScene().getWindow();
            currentStage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/editWorker.fxml"));

            Parent root1 = (Parent) fxmlLoader.load();

            EditWorkerController controller = fxmlLoader.<EditWorkerController>getController();
            controller.setUserRole(userRole);


            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
  //      displayController.viewFXML(editWorkersTableButton, "/fxml/editWorker.fxml" );
    }

    public void viewEditAppartmentTable() {
        try {

            Stage currentStage = (Stage) editAppartmentsTableButton.getScene().getWindow();
            currentStage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/editSaledAppartment.fxml"));

            Parent root1 = (Parent) fxmlLoader.load();

            EditSaledAppartmentController controller = fxmlLoader.<EditSaledAppartmentController>getController();
            controller.setUserRole(userRole);


            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
  //      displayController.viewFXML(editAppartmentsTableButton, "/fxml/editSaledAppartment.fxml");
    }

    public void viewEditDealsTable() {
        try {

            Stage currentStage = (Stage) editDealstTableButton.getScene().getWindow();
            currentStage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/editDeals.fxml"));

            Parent root1 = (Parent) fxmlLoader.load();

            EditDealsController controller = fxmlLoader.<EditDealsController>getController();
            controller.setUserRole(userRole);


            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
      //  displayController.viewFXML(editDealstTableButton, "/fxml/editDeals.fxml" );
    }

    public void viewTimeTrackingTable() {
        try {

            Stage currentStage = (Stage) editDealstTableButton.getScene().getWindow();
            currentStage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/timeTracking.fxml"));

            Parent root1 = (Parent) fxmlLoader.load();

            TimeTrackingViewController controller = fxmlLoader.<TimeTrackingViewController>getController();
            controller.setUserRole(userRole);


            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    //    displayController.viewFXML(editDealstTableButton, "/fxml/timeTracking.fxml" );
    }

    public void viewFreeAppartment() {


        try {

            Stage currentStage = (Stage) editDealstTableButton.getScene().getWindow();
            currentStage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/freeAppartmentView.fxml"));

            Parent root1 = (Parent) fxmlLoader.load();

            FreeAppartmentViewController controller = fxmlLoader.<FreeAppartmentViewController>getController();
            controller.setUserRole(userRole);


            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
      //  displayController.viewFXML(editDealstTableButton, "/fxml/freeAppartmentView.fxml" );
    }

    public void viewEditFreeAppartment() {
        try {

            Stage currentStage = (Stage) editDealstTableButton.getScene().getWindow();
            currentStage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/editFreeAppartment.fxml"));

            Parent root1 = (Parent) fxmlLoader.load();

            EditFreeAppartmentController controller = fxmlLoader.<EditFreeAppartmentController>getController();
            controller.setUserRole(userRole);


            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
       // displayController.viewFXML(editDealstTableButton, "/fxml/editFreeAppartment.fxml" );
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

    public void createFreeAppartmentReport() throws Exception {
        InputStream inputStream = null;
        InputStream pin = null;
        try {
           /* inputStream = new FileInputStream("/jrxml/manager_report.jrxml");*/
            java.net.URL url = this.getClass().getResource("/jrxml/free_apparment_report.jrxml");
            pin = new java.io.FileInputStream(url.getFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        FreeApparmentDataBeanMaker freeApparmentDataBeanMaker = new FreeApparmentDataBeanMaker();
        ArrayList<FreeApparmentReport> userRolesReports = freeApparmentDataBeanMaker.getDataBeanList();

        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(userRolesReports);

        Map parameters = new HashMap();

        JasperDesign jasperDesign = JRXmlLoader.load(pin);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, "free_appartment_report.pdf");
        JasperExportManager.exportReportToHtmlFile(jasperPrint, "free_appartment_report.html");
        JRXlsxExporter exporter = new JRXlsxExporter();
        exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, "free_appartment_report.xlsx");
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

    public void createDealReport() throws Exception {
        InputStream inputStream = null;
        InputStream pin = null;
        try {
           /* inputStream = new FileInputStream("/jrxml/manager_report.jrxml");*/
            java.net.URL url = this.getClass().getResource("/jrxml/deal_report.jrxml");
            pin = new java.io.FileInputStream(url.getFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        DealDataBeanMaker clientDataBeanMaker = new DealDataBeanMaker();
        ArrayList<DealReport> dataBeanList = clientDataBeanMaker.getDataBeanList();

        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);

        Map parameters = new HashMap();

        JasperDesign jasperDesign = JRXmlLoader.load(pin);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, "deal_report.pdf");
        JasperExportManager.exportReportToHtmlFile(jasperPrint, "deal_report.html");
        JRXlsxExporter exporter = new JRXlsxExporter();
        exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, "deal_report.xlsx");
        exporter.exportReport();
        System.out.println("Completed");
    }

    public void initialize(URL location, ResourceBundle resources) {

    }


}
