package com.ayushtiwari;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

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
        if (branchId.getText().trim().isEmpty() || cityName.getText().isEmpty() || streetName.getText().isEmpty()) {
            if (branchId.getText().trim().isEmpty()) branchId.validate();
            if (cityName.getText().trim().isEmpty()) cityName.validate();
            if (streetName.getText().trim().isEmpty()) streetName.validate();
        } else {
            //Add Branch to database


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
