//One of the functionalities of a manager is he can add a new truck if he feels so
//This is achieved by this corresponding class
//Accordingly, details of truck will be updated in sqlite database
package com.ayushtiwari.ManagerUI;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.sql.*;
import java.time.LocalDateTime;

public class NewTruckController {

    @FXML
    private JFXTextField truckId;

    @FXML
    private JFXTextField capacity;

    @FXML
    private JFXComboBox<String> branch;

    private int truckCount = 1;


    public void initialize() {

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/TransportDatabase.db");
            Statement statement = connection.createStatement();

            statement.execute("SELECT * FROM Offices");
            ResultSet results = statement.getResultSet();

            while (results.next()) {
                int branchid = results.getInt(1);
                branch.getItems().add(Integer.toString(branchid));
            }

            results = statement.executeQuery("SELECT * FROM Trucks");
            while (results.next()) truckCount++;


        } catch (SQLException s) {
            System.out.println("Error accessing Database" + s.getMessage());
        }


        RequiredFieldValidator validator = new RequiredFieldValidator();
        truckId.getValidators().add(validator);
        validator.setMessage("Required");

        validator.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    truckId.validate();
                }
            }
        });

        truckId.setText(truckCount + "");
        truckId.setDisable(true);
        RequiredFieldValidator validator1 = new RequiredFieldValidator();
        branch.getValidators().add(validator);
        validator1.setMessage("Required");

        validator1.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    branch.validate();
                }
            }
        });

        RequiredFieldValidator validator2 = new RequiredFieldValidator();
        capacity.getValidators().add(validator);
        validator2.setMessage("Required");

        validator2.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    capacity.validate();
                }
            }
        });

    }

    public void onSubmit() {
        if (truckId.getText().trim().isEmpty() || capacity.getText().trim().isEmpty() || branch.getItems().isEmpty()) {
            if (truckId.getText().trim().isEmpty()) truckId.validate();
            if (capacity.getText().trim().isEmpty()) capacity.validate();
            if (branch.getItems().isEmpty()) branch.validate();
        } else {


            String arrivalTime = LocalDateTime.now().toString();

            String trucklist = "*";

            try {


                Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/TransportDatabase.db");
                Statement st = conn.createStatement();

                st.execute("INSERT INTO Trucks VALUES (" + Integer.parseInt(truckId.getText()) + "," + Integer.parseInt(branch.getValue()) + "," + "-1" + "," + 0 + "," + Integer.parseInt(capacity.getText()) + ",'" + LocalDateTime.now().toString() + "'," + "'*'" + "," + 0 + ")");


                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Truck Successfully Added");
                alert.setTitle("Success");
                alert.showAndWait();

                truckId.clear();
                branch.setValue("");
                capacity.clear();

                truckCount++;

                truckId.setText(truckCount + "");
                truckId.setDisable(true);

            } catch (SQLException e) {

                System.out.println("Something went wrong" + e.getMessage());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("There was some problem in adding Truck.");
                alert.setTitle("Failure");
                alert.showAndWait();

            }



        }
    }


}
