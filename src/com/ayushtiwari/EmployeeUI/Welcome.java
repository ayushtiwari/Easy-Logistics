package com.ayushtiwari.EmployeeUI;

import com.ayushtiwari.TransportCompanyData.TransportData;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Welcome {

    @FXML
    private Label employeeName;

    public void initialize() {

        employeeName.setText(TransportData.getInstance().getEmployeeUserName());

    }

}
