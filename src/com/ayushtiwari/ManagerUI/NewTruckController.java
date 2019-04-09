package com.ayushtiwari.ManagerUI;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.util.ArrayList;

public class NewTruckController {

    @FXML
    private JFXTextField truckId;

    @FXML
    private JFXTextField capacity;

    @FXML
    private JFXComboBox<String> branch;


    public void initialize() {

        ArrayList<String> branchIDs = new ArrayList<>();
        /*
         *   Get All BranchID's from database
         *   populate branch drop down
         *
         *
         */

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

            /*
             *
             *    Do necessary database update
             *
             */

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Truck Successfully Added");
            alert.showAndWait();

            truckId.clear();
            branch.getItems().clear();
            capacity.clear();

        }
    }


}
