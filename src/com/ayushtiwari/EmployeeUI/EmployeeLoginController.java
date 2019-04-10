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
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/database1-2.db");
            Statement st = conn.createStatement();
            st.execute("SELECT * FROM office");
            ResultSet results = st.getResultSet();
            while (results.next()) {
                int branchid = results.getInt(1);

                branch.getItems().add(Integer.toString(branchid));
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

        String employeeBranch = branch.getValue();
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
                Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/database1-2.db");
                Statement st = conn.createStatement();
                st.execute("SELECT * FROM employee");
                ResultSet results = st.getResultSet();
                while (results.next()) {
                    boolean a = employeeUserName.equals(results.getString(4)) && employeePassWord.equals(results.getString(5));
                    detailsCorrect = a && employeeBranch.equals(Integer.toString(results.getInt(3)));
                    if (detailsCorrect == true) break;
                }
            } catch (SQLException e) {
                System.out.println("Something went wrong");
            }
               
                if (detailsCorrect) {
                    /*
                    //get Branch Details
                    //getEmployee Details
                    */

                    // String truckList = "", consignmentList = "", employeeList = "", employeeId = "";
//                    try {
//                        Connection conn1 = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/database1-2.db");
//                        Statement st1 = conn1.createStatement();
//                        st1.execute("SELECT * FROM office");
//                        ResultSet results1 = st1.getResultSet();
//                        while (results1.next()) {
//
//                            if (results1.getInt(1) == Integer.parseInt(branch.getValue())) {
//                                truckList = results1.getString(5);
//                                consignmentList = results1.getString(6);
//                                employeeList = results1.getString(2);
//                            }
//                        }
//
//
//                        st1.close();
//                        conn1.close();
//                        } catch (SQLException e) {
//                        System.out.println("alphabetagamma");
//                        System.out.println("Something went wrong" + e.getMessage());
//                    }

                /*    Connection conn3 = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/database1-2.db");
                    Statement st3 = conn.createStatement();
                    st.execute("SELECT * FROM employee");
                    ResultSet results3 = st.getResultSet();
                    while (results3.next()) {
                        if (results3.getString(4).equals(userName.getText())) {
                            employeeId = results3.getString(1);
                        }

                    }*/
                    TransportData.getInstance().setOfficeId(Integer.parseInt(branch.getValue()));
                    TransportData.getInstance().setEmployeeUserName(userName.getText());

                    //System.out.println(TransportData.getInstance().getEmployeeId());
                    //System.out.println(TransportData.getInstance().getOfficeId());

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
         /*    catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Something went wrong. Please try again.");
                System.out.println("Something went wrong: " + e.getMessage());
            }*/



        }

    }

}
