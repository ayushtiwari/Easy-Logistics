//Our Manager can add a new branch if he feels so
//This class enables the manager to add new branch
//Database implementation has been done through sqlite
//When manager adds a new branch,accordingly it will be added to database through JDBC
package com.ayushtiwari.ManagerUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.sql.*;

public class NewBranchController {

    @FXML
    private JFXTextField branchId;

    @FXML
    private JFXButton submit;

    @FXML
    private JFXTextField streetName;

    @FXML
    private JFXTextField cityName;

    public void initialize() {


        RequiredFieldValidator validator = new RequiredFieldValidator();
        branchId.getValidators().add(validator);
        validator.setMessage("Required");
        branchId.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue)
                    branchId.validate();
            }
        });

        RequiredFieldValidator validator1 = new RequiredFieldValidator();
        streetName.getValidators().add(validator);
        validator1.setMessage("Required");
        streetName.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue)
                    streetName.validate();
            }
        });

        RequiredFieldValidator validator2 = new RequiredFieldValidator();
        cityName.getValidators().add(validator);
        validator2.setMessage("Required");
        cityName.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue)
                    cityName.validate();
            }
        });

        int branchCount = 1;

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/TransportDatabase.db");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Offices");

            while (resultSet.next()) {
                branchCount++;
            }


        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Branch addition failure." + e.getMessage());
            alert.setTitle("Failed");
            alert.showAndWait();
        }

        branchId.setText(branchCount + "");
        branchId.setDisable(true);


    }

    @FXML
    public void handleOnSubmit() {
        int branchid = Integer.parseInt(branchId.getText());
        String cityname=cityName.getText();
        String streetname=streetName.getText();

        if (branchId.getText().trim().isEmpty() || cityName.getText().isEmpty() || streetName.getText().isEmpty()) {
            if (branchId.getText().trim().isEmpty()) branchId.validate();
            if (cityName.getText().trim().isEmpty()) cityName.validate();
            if (streetName.getText().trim().isEmpty()) streetName.validate();
        } else {

            try {
                Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/TransportDatabase.db");
                Statement st = conn.createStatement();


                st.execute("INSERT INTO Offices VALUES ('" + branchid + "','" + streetname + "','" + cityname + "')");


                st.close();
                conn.close();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Branch Succesfully Added");
                alert.setTitle("Success");
                alert.showAndWait();
                branchId.clear();
                cityName.clear();
                streetName.clear();

            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Branch addition failure." + e.getMessage());
                alert.setTitle("Failed");
                alert.showAndWait();
            }


            initialize();

        }
    }

}
