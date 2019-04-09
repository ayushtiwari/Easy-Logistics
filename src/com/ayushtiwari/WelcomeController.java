package com.ayushtiwari;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton managerLogin;

    @FXML
    private JFXButton employeeLogin;

    @FXML
    void onEmployeeLoginClick(ActionEvent event) throws Exception {
        Parent employeeLogin = FXMLLoader.load(getClass().getResource("EmployeeUI/employeeLogin.fxml"));
        Scene loginScreen = new Scene(employeeLogin);
        Stage window = new Stage();
        window.setTitle("Employee Login");
        window.setScene(loginScreen);
        window.initModality(Modality.WINDOW_MODAL);
        window.initOwner(((Node) event.getSource()).getScene().getWindow());
        window.show();
    }

    @FXML
    void onManagerLoginClick(ActionEvent event) throws Exception {
        System.out.println("a");
        Parent managerLogin = FXMLLoader.load(getClass().getResource("ManagerUI/managerLogin.fxml"));
        System.out.println("a");
        Scene loginScreen = new Scene(managerLogin);
        System.out.println("a");
        Stage window = new Stage();
        System.out.println("a");
        window.setTitle("Manager Login");
        window.setScene(loginScreen);
        window.initModality(Modality.WINDOW_MODAL);
        window.initOwner(((Node) event.getSource()).getScene().getWindow());
        window.setResizable(false);
        window.show();
    }

    @FXML
    void handleEnterKey(KeyEvent event) throws Exception {
        if (event.getCode() == KeyCode.ENTER && event.getSource() == managerLogin) {
            Parent managerLogin = FXMLLoader.load(getClass().getResource("ManagerUI/managerLogin.fxml"));
            Scene loginScreen = new Scene(managerLogin);
            Stage window = new Stage();
            window.setTitle("Manager Login");
            window.setScene(loginScreen);
            window.initModality(Modality.WINDOW_MODAL);
            window.initOwner(((Node) event.getSource()).getScene().getWindow());
            window.setResizable(false);
            window.show();
        } else {
            if (event.getCode() == KeyCode.ENTER && event.getSource() == employeeLogin) {
                Parent employeeLogin = FXMLLoader.load(getClass().getResource("EmployeeUI/employeeLogin.fxml"));
                Scene loginScreen = new Scene(employeeLogin);
                Stage window = new Stage();
                window.setTitle("Employee Login");
                window.setScene(loginScreen);
                window.initModality(Modality.WINDOW_MODAL);
                window.initOwner(((Node) event.getSource()).getScene().getWindow());
                window.show();
            }
        }

    }

    @FXML
    void initialize() {

    }
}

