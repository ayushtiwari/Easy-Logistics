package com.ayushtiwari.EmployeeUI;

import com.ayushtiwari.TransportCompanyData.TransportData;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.sql.*;
import java.time.LocalDateTime;

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

    private int consignmentCount = 1;

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

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
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


        currentOfficeId.setText(Integer.toString(TransportData.getInstance().getOfficeId()));

        currentOfficeId.setDisable(true);
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/TransportDatabase.db");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Consignments");
            while (resultSet.next()) consignmentCount++;

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException se) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(se.getMessage());
            alert.setTitle("Error");
            alert.showAndWait();
        }

        consignment.setText(consignmentCount + "");
        consignment.setDisable(true);

    }

    public void onSubmitClick() {

        if (senderName.getText().trim().isEmpty() || senderCity.getText().trim().isEmpty() || senderStreetName.getText().trim().isEmpty()
                || senderStreetName.getText().trim().isEmpty() || receiverCity.getText().trim().isEmpty() || receiverName.getText().trim().isEmpty()
                || consignment.getText().trim().isEmpty() || currentOfficeId.getText().trim().isEmpty() || volume.getText().trim().isEmpty()
                || nextOffice.getText().trim().isEmpty() || receiverStreetName.getText().trim().isEmpty() || !isInteger(nextOffice.getText())
                || !isInteger(volume.getText())) {

            if (senderName.getText().trim().isEmpty()) {
                senderName.validate();
            }
            if (senderCity.getText().trim().isEmpty())
                senderCity.validate();
            if (senderStreetName.getText().trim().isEmpty())
                senderStreetName.validate();
            if (receiverCity.getText().trim().isEmpty())
                receiverCity.validate();
            if (receiverName.getText().trim().isEmpty())
                receiverName.validate();
            if (senderStreetName.getText().trim().isEmpty())
                senderStreetName.validate();
            if (nextOffice.getText().trim().isEmpty())
                currentOfficeId.validate();
            if (!isInteger(volume.getText())) volume.validate();
            if (!isInteger(nextOffice.getText())) nextOffice.validate();


        } else {

            //Allot Truck
            int truckAlloted = -1;
            try {
                Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/TransportDatabase.db");
                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT * FROM Trucks WHERE currentBranchID=" + currentOfficeId.getText() + " ORDER BY currentOccupancy DESC ");

                int newOccupancy = 0;

                while (resultSet.next()) {

                    System.out.println(resultSet.getInt("currentOccupancy") + " " + resultSet.getInt("nextBranchID"));

                    if (resultSet.getInt("currentOccupancy") == 0) {

                        if (resultSet.getInt("capacity") >= Integer.parseInt(volume.getText())) {

                            truckAlloted = resultSet.getInt("_id");
                            newOccupancy = Integer.parseInt(volume.getText());
                            break;

                        }

                    } else if (resultSet.getInt("nextBranchID") == Integer.parseInt(nextOffice.getText())) {
                        if (resultSet.getInt("currentOccupancy") + Integer.parseInt(volume.getText()) <= resultSet.getInt("capacity")) {
                            System.out.println("afjdlsalkfjdslkfjd;lksf;sadjf;lasdkjfl;asjdflkaj;lfdjsf");
                            truckAlloted = resultSet.getInt("_id");
                            newOccupancy = newOccupancy + resultSet.getInt("currentOccupancy") + Integer.parseInt(volume.getText());
                            break;
                        }
                    }
                }

                if (truckAlloted != -1) {

                    System.out.println(truckAlloted);


                    statement.executeUpdate("UPDATE Trucks SET currentOccupancy=" + newOccupancy + " WHERE _id=" + truckAlloted);

                    statement.executeUpdate("UPDATE Trucks SET nextBranchID=" + nextOffice.getText() + " WHERE _id=" + truckAlloted);


                    resultSet = statement.executeQuery("SELECT * FROM Customers");

                    int senderId = 1;
                    while (resultSet.next()) senderId++;
                    int receiverId = senderId + 1;

                    System.out.println("Sender id = " + senderId);

                    System.out.println(truckAlloted + "a");

                    statement.executeUpdate("INSERT INTO Customers VALUES (" + senderId + ", " + Integer.parseInt(consignment.getText()) + " , '" + senderStreetName.getText() + "' , '" + senderCity.getText() + "','" + senderName.getText() + "' )");

                    System.out.println(truckAlloted);

                    statement.executeUpdate("INSERT INTO Customers VALUES (" + receiverId + "," + Integer.parseInt(consignment.getText()) + ",'" + receiverStreetName.getText() + "','" + receiverCity.getText() + "','" + receiverName.getText() + "')");


                    System.out.println(truckAlloted);


                    System.out.println(truckAlloted);

                    statement.executeUpdate("INSERT INTO Consignments VALUES (" + consignment.getText() + "," + volume.getText() + "," + truckAlloted + "," +
                            currentOfficeId.getText() + ", " + nextOffice.getText() + ", '" + LocalDateTime.now().toString() + "', '*', '*', " + 0 + ")");


                    System.out.println(truckAlloted);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setContentText("Truck Id " + truckAlloted + " Successfully Allotted");
                    alert.showAndWait();

                    consignment.clear();

                    senderName.clear();
                    senderCity.clear();
                    senderStreetName.clear();
                    receiverCity.clear();
                    receiverName.clear();
                    receiverStreetName.clear();
                    consignment.clear();
                    currentOfficeId.clear();
                    volume.clear();
                    nextOffice.clear();

                    consignmentCount++;
                    consignment.setText(consignmentCount + "");
                    consignment.setDisable(true);
                    currentOfficeId.setText(Integer.toString(TransportData.getInstance().getOfficeId()));
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Failure");
                    alert.setContentText("No Truck Leaving from this Branch");
                    alert.showAndWait();
                }


                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException se) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(se.getMessage());
                alert.setTitle("Error");
                alert.showAndWait();
            }

        }


    }
}

