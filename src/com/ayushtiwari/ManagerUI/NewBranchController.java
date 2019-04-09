package com.ayushtiwari.ManagerUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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


    }

    @FXML
    public void handleOnSubmit() {
        String branchid=branchId.getText();
        String cityname=cityName.getText();
        String streetname=streetName.getText();
        if (branchId.getText().trim().isEmpty() || cityName.getText().isEmpty() || streetName.getText().isEmpty()) {
            if (branchId.getText().trim().isEmpty()) branchId.validate();
            if (cityName.getText().trim().isEmpty()) cityName.validate();
            if (streetName.getText().trim().isEmpty()) streetName.validate();
        } else {
            //Add Branch to database
           try {
               Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/database1.db");
               //Connection conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Nikhil//Desktop//TransportCompany//database1.db");
               Statement st = conn.createStatement();
               st.execute("INSERT INTO office VALUES ('" + branchid + "','*','" + streetname + "','" + cityname + "','*','*')");
              // st.execute("INSERT INTO office VALUES (1,'NULL','ehfuef','oiivn','NULL','NULL')");
               st.close();
               conn.close();
               System.out.println("AlpahBeta");


           }catch(SQLException e)
           {
               System.out.println("Something went wrong: " + e.getMessage());
           }


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Branch Succesfully Added");
            alert.setTitle("Success");
            alert.showAndWait();

            branchId.clear();
            cityName.clear();
            streetName.clear();

        }
    }

}
