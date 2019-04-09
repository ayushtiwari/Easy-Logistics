package com.ayushtiwari.EmployeeUI;

import com.ayushtiwari.TransportClasses.Address;
import com.ayushtiwari.TransportClasses.Employee;
import com.ayushtiwari.TransportClasses.Office;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;

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

        branch.getItems().add("AlphaBeta");

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

        String employeeBranch = branch.getValue();
        String employeeUserName = userName.getText();
        String employeePassWord = password.getText();

        if (employeeUserName.trim().isEmpty() || employeePassWord.trim().isEmpty()) {
            System.out.println("Empty TextBox");
        } else {
            /*
            Validate Employee;
             */
            boolean detailsCorrect = true;
            if (detailsCorrect) {


                //get Branch Details
                //getEmployee Details


                Office office = new Office(123, new Address("ch", "dhh"));
                Employee employee = new Employee(1234, "Alpha", office, "1245", "abcd");
                TransportData.getInstance().setCurrentEmployee(employee);

                Parent employeeDashboard = FXMLLoader.load(getClass().getResource("employeeDashboard.fxml"));
                Scene dashboard = new Scene(employeeDashboard);
                Stage windowDashboard = new Stage();
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.getOwner().hide();

                windowDashboard.setTitle("Dashboard - " + TransportData.getInstance().getCurrentEmployee().getName());
                windowDashboard.setScene(dashboard);
                window.setMaxHeight(728);
                window.setMaxWidth(1366);
                windowDashboard.show();

            } else {
                incorrectDetails.setText("Incorrect Details");
            }
        }

    }

}
