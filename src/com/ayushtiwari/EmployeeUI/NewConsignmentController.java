package com.ayushtiwari.EmployeeUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class NewConsignmentController {

    @FXML
    private JFXTextField senderName;

    @FXML
    private JFXTextField senderStreetName;

    @FXML
    private JFXTextField receiverName;

    @FXML
    private JFXTextField receiverStreetName;

    @FXML
    private JFXTextField senderCity;

    @FXML
    private JFXTextField receiverCity;

    @FXML
    private JFXTextField consignment;

    @FXML
    private JFXTextField volume;

    @FXML
    private JFXTextField currentOfficeId;
    @FXML
    private JFXTextField nextOffice;
    @FXML
    private JFXButton submit;

    public void validation(JFXTextField textField) {
        RequiredFieldValidator senderNameValidator = new RequiredFieldValidator();
        textField.getValidators().add(senderNameValidator);
        senderNameValidator.setMessage("Required");

        textField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    textField.validate();
                }
            }
        });
    }

    public void initialize() {

        validation(senderName);
        validation(senderCity);
        validation(senderStreetName);
        validation(receiverCity);
        validation(receiverName);
        validation(receiverStreetName);
        validation(consignment);
        validation(currentOfficeId);
        validation(volume);
        validation(nextOffice);
    }

    public void onSubmitClick() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        boolean success = true;

        //Assign Truck

        alert.setTitle("Message");

        if (!success) {

            alert.setContentText("Truck Allocation Successfull");
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Consignment could not be added. No Truck goes to the destination");
        }
        Optional<ButtonType> result = alert.showAndWait();

        senderName.clear();
        senderStreetName.clear();
        senderCity.clear();
        receiverName.clear();
        receiverCity.clear();
        receiverStreetName.clear();
        consignment.clear();
        volume.clear();
        currentOfficeId.clear();

    }


}
