package com.ayushtiwari.EmployeeUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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

        int truckid = 12;
        try {
            System.out.println("asdfgj");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/database1-2.db");
            System.out.println("asdfgj");
            Statement st = conn.createStatement();
            System.out.println("asdfgj");
            st.execute("INSERT INTO consignment VALUES ('" + consignment.getText() + "','" + volume.getText() + "','" + senderName
                    .getText() + "','" + senderStreetName.getText() + "','" + senderCity.getText() + "','" + receiverName
                    .getText() + "','" + receiverStreetName.getText() + "','" + receiverCity + "','NOT DISPATCHED','NOT DELIVERED','NULL','NULL','NULL','" + currentOfficeId.getText() + "','" + nextOffice.getText() + "','" + truckid + "')");
            st.close();
            System.out.println("asdfgj");
            conn.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong" + e.getMessage());
            success = false;
        }


        alert.setTitle("Message");

        if (success) {

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
