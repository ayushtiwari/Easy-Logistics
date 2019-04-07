package com.ayushtiwari.ManagerUI;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.sql.*;

public class NewEmployeeController {

    @FXML
    private JFXTextField employeeId;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXComboBox<String> branch;

    @FXML
    private JFXTextField userName;

    @FXML
    private JFXTextField password;

    public void initialize() {


        /*
        *   Go to database and get all the branch ID
        *
        *   for(get string:i from datbase) {
        *
        *       branch.getItems.add(string);
        * }
        *
         */
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Nikhil//Desktop//TransportCompany//database1.db");
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
        employeeId.getValidators().add(validator);
        validator.setMessage("Required");

        employeeId.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    employeeId.validate();
                }
            }
        });

        RequiredFieldValidator validator1 = new RequiredFieldValidator();
        name.getValidators().add(validator);
        validator1.setMessage("Required");

        name.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    name.validate();
                }
            }
        });

        RequiredFieldValidator validator2 = new RequiredFieldValidator();
        branch.getValidators().add(validator);
        validator2.setMessage("Required");

        branch.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    branch.validate();
                }
            }
        });

        RequiredFieldValidator validator3 = new RequiredFieldValidator();
        userName.getValidators().add(validator);
        validator3.setMessage("Required");

        userName.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    userName.validate();
                }
            }
        });

        RequiredFieldValidator validator4 = new RequiredFieldValidator();
        password.getValidators().add(validator);
        validator4.setMessage("Required");

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
    public void handleSubmit() {
        String employeelist = "";
        if (employeeId.getText().trim().isEmpty() || password.getText().trim().isEmpty() || userName.getText().isEmpty() || branch.getItems().isEmpty() || name.getText().isEmpty()) {
            if (employeeId.getText().isEmpty()) employeeId.validate();
            if (password.getText().isEmpty()) password.validate();
            if (userName.getText().isEmpty()) userName.validate();
            if (branch.getItems().isEmpty()) branch.validate();
            if (name.getText().isEmpty()) name.validate();
        } else {

            //Add Employee To database
            try {
                Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/database1.db");
                //Connection conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Nikhil//Desktop//TransportCompany//database1.db");
                Statement st = conn.createStatement();
                st.execute("INSERT INTO  employee VALUES('" + employeeId.getText() + "','" + name.getText() + "','" + branch.getValue() + "','" + userName.getText() + "','" + password.getText() + "')");
                st.execute("SELECT * FROM office");
                ResultSet results = st.getResultSet();
                while (results.next()) {
                    if (results.getInt(1) == Integer.parseInt(branch.getValue()))
                        employeelist = results.getString(2) + employeeId.getText() + ",";
                    System.out.println(employeelist);
                    int officeIdValue = Integer.parseInt(branch.getValue());
                    //st.execute("INSERT INTO office(employee_list)VALUE('"+employeelist+"') WHERE office_id=Integer.parseInt(branch.getValue())");
                    st.execute("UPDATE office SET employee_list=('" + employeelist + "') WHERE office_id=('" + officeIdValue + "')");
                }
            } catch (SQLException e) {
                System.out.println("Something went wrong" + e.getMessage());
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Employee Successfully Created");
            alert.showAndWait();

            employeeId.clear();
            password.clear();
            userName.clear();
            branch.getSelectionModel().clearSelection();
            name.clear();

        }
    }


}
