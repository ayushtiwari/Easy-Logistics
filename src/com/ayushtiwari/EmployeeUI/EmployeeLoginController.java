package com.ayushtiwari.EmployeeUI;

import com.ayushtiwari.TransportCompanyData.TransportData;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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

public class EmployeeLoginController {

    @FXML
    private JFXTextField userName;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton logIn;

    @FXML
    private Label incorrectDetails;

    @FXML
    private JFXComboBox<String> branch;

    public void initialize() {

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/TransportDatabase.db");
            Statement st = conn.createStatement();
            st.execute("SELECT * FROM Offices");
            ResultSet results = st.getResultSet();
            while (results.next()) {
                int branchid = results.getInt(1);
                String branchCity = results.getString("city");
                branch.getItems().add(branchid + " " + branchCity);
            }
        } catch (SQLException s) {
            System.out.println("Error accessing Database" + s.getMessage());
        }


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
        RequiredFieldValidator validator3 = new RequiredFieldValidator();
        branch.getValidators().add(validator2);
        validator3.setMessage("Required");

        branch.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    branch.validate();
                }
            }
        });


    }

    public void onLogin(ActionEvent event) throws Exception {

        String employeeUserName = userName.getText();
        String employeePassWord = password.getText();

        if (employeeUserName.trim().isEmpty() || employeePassWord.trim().isEmpty()) {
            System.out.println("Empty TextBox");
        } else {
            /*
            Validate Employee;
             */
            boolean detailsCorrect = false;


            try {
                Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/TransportDatabase.db");
                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT * FROM Employees WHERE userName = '" + employeeUserName + "'");

                if (resultSet.next() && resultSet.getString("userName").equals(employeeUserName) && resultSet.getString("password").equals(employeePassWord)) {
                    detailsCorrect = true;
                }
                System.out.println("Alphabeta");
                if (detailsCorrect) {

                    TransportData.getInstance().setOfficeId(resultSet.getInt(5));
                    TransportData.getInstance().setEmployeeUserName(resultSet.getString(3));
                    TransportData.getInstance().setEmployeeId(resultSet.getInt(1));

                    Parent employeeDashboard = FXMLLoader.load(getClass().getResource("employeeDashboard.fxml"));
                    Scene dashboard = new Scene(employeeDashboard);
                    Stage windowDashboard = new Stage();
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.getOwner().hide();

                    windowDashboard.setTitle("Dashboard - ");
                    windowDashboard.setScene(dashboard);
                    window.setMaxHeight(728);
                    window.setMaxWidth(1366);
                    windowDashboard.show();

                } else {
                    incorrectDetails.setText("Incorrect Details");
                }
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(e.getMessage());
                alert.setTitle("Error");
                alert.showAndWait();
            }


        }

    }

}
