package com.ayushtiwari.EmployeeUI;

import com.ayushtiwari.TransportCompanyData.TransportData;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.*;
import java.time.LocalDateTime;
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


        currentOfficeId.setText(Integer.toString(TransportData.getInstance().getOfficeId()));

        currentOfficeId.setDisable(true);


    }

    public void onSubmitClick() {


        int truckid = 0;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        boolean success = true;

        String datetime = LocalDateTime.now().toString();
        datetime = datetime.split("T")[0] + "  " + datetime.split("T")[1];


        String trucklist = "";

        int branchid = TransportData.getInstance().getOfficeId();
        String a = "";
        String b = "";
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/database1-2.db");
            Statement st = conn.createStatement();
            st.execute("SELECT * FROM office");
            ResultSet results = st.getResultSet();
            while (results.next()) {
                if (results.getInt(1) == branchid)
                    a = results.getString(5);
            }
            results.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if (a.equals("*")) {
        } else {
            for (String s : a.substring(1).split(",")) {
                System.out.println(s);
            }


            for (String s : a.substring(1).split(",")) {
                try {
                    Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/database1-2.db");
                    Statement st = conn.createStatement();
                    st.execute("SELECT * FROM truck");
                    ResultSet results = st.getResultSet();
                    while (results.next()) {
                        if (results.getInt(1) == Integer.parseInt(s)) {
                            System.out.println(results.getInt(11));//curr occupancy
                            System.out.println(results.getInt(4));//max


                            if (results.getInt(11) == 0) {
                                b = results.getString(9);
                                b = b + s + ",";
                                st.execute("UPDATE truck SET consignment_list=('" + b + "') WHERE truck_id=('" + Integer.parseInt(s) + "')");

                            } else {

                            }


                        }
                    }


                    results.close();
                    st.close();
                    conn.close();

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }


            try {
                System.out.println("asdfgj");
                Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/database1-2.db");
                System.out.println("asdfgj");
                Statement st = conn.createStatement();
                System.out.println("asdfgj");
                st.execute("INSERT INTO consignment VALUES ('" + consignment.getText() + "','" + volume.getText() + "','" + senderName
                        .getText() + "','" + senderStreetName.getText() + "','" + senderCity.getText() + "','" + receiverName
                        .getText() + "','" + receiverStreetName.getText() + "','" + receiverCity + "','false','false','" + datetime + "','*','*','" + currentOfficeId.getText() + "','" + nextOffice.getText() + "','" + truckid + "')");

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
}