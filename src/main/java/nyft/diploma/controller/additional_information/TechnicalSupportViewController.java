package nyft.diploma.controller.additional_information;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import nyft.diploma.controller.DisplayController;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by Vladyslav.Nasadiuk on 16.05.2016.
 */
public class TechnicalSupportViewController {
    @FXML
    private Button toMenuButton = new Button();

    @FXML
    private Button sendButton = new Button();

    @FXML
    private TextArea supportComment = new TextArea();

    @FXML
    private TextField supportName = new TextField();

    @FXML
    private TextField supportEmail = new TextField();

    @FXML
    private Label statusLabel = new Label();

    DisplayController displayController = new DisplayController();

    public void sendEmail() {
        final String username = "yeapless@gmail.com";
        final String password = "75367536";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("yeapless@gmail.com")); //from
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("nasadiuk.vlad@gmail.com")); //to
            message.setSubject("Support from user");
            message.setText("E-mail відправника: " + supportEmail.getText() + "\n" + "Ім'я відправника: " + supportName.getText() + "\n" + "Коментар: " + supportComment.getText() + "\n");

            Transport.send(message);

            System.out.println("Done");
            statusLabel.setVisible(true);
            statusLabel.setTextFill(Color.web("#44C53D"));
            sendButton.setDisable(true);
        } catch (MessagingException e) {
            statusLabel.setVisible(true);
            statusLabel.setText("Помилка при відправленні!");
            statusLabel.setTextFill(Color.web("#E25A53"));
            throw new RuntimeException(e);

        }

        sendButton.setDisable(true);
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
}
