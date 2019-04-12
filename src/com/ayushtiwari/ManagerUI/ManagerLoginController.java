//This class is meant for manager login
//
package com.ayushtiwari.ManagerUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.*;

public class ManagerLoginController {

    @FXML
    private JFXTextField userName;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton logIn;

    @FXML
    private Label incorrectDetails;

    public void initialize() {
        incorrectDetails.setText("");

        RequiredFieldValidator validator = new RequiredFieldValidator();
        userName.getValidators().add(validator);
        validator.setMessage("Required");

        userName.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    userName.validate();
                }
            }
        });
        RequiredFieldValidator validator2 = new RequiredFieldValidator();
        password.getValidators().add(validator2);
        validator2.setMessage("Required");

        password.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    password.validate();
                }
            }
        });


    }

    @FXML
    public void onLogin(ActionEvent event) throws Exception {
        String managerUserName = userName.getText();
        String managerPassword = password.getText();
        boolean detailsCorrect = false;


        if (managerUserName.trim().isEmpty() || managerPassword.trim().isEmpty()) {


        } else {
            /*
            Check if Password is correct
            */


            try {
                Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/TransportDatabase.db");

                Statement st = conn.createStatement();
                st.execute("SELECT * FROM Manager");


                ResultSet results = st.getResultSet();
                detailsCorrect = managerUserName.equals(results.getString(2)) && managerPassword.equals(results.getString(3));



                st.close();
                conn.close();


                if (detailsCorrect) {
                    Parent dashboard = FXMLLoader.load(getClass().getResource("managerDashboard.fxml"));
                    Scene dashboardScene = new Scene(dashboard);
                    Stage windowDashboard = new Stage();
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.getOwner().hide();
                    windowDashboard.setScene(dashboardScene);
                    window.setMaxHeight(728);
                    window.setMaxWidth(1366);
                    windowDashboard.show();
                } else {


                }

            } catch (SQLException e) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Something went wrong. Please try again." + e.getMessage());
                alert.showAndWait();
            }

        }

    }
}
