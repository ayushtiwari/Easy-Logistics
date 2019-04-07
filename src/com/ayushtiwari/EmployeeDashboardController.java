package com.ayushtiwari;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;

public class EmployeeDashboardController {


    @FXML
    private ScrollPane scrollPane;

    @FXML
    private JFXButton dispatchTruck;

    @FXML
    private JFXButton receiveTruck;

    @FXML
    private JFXButton newConsignment;

    @FXML
    private JFXButton consignmentHistory;

    @FXML
    private JFXButton printBill;

    @FXML
    private JFXButton customerContacts;


    @FXML
    void onConsignmentHistoryClicked(MouseEvent event) throws Exception {

    }

    @FXML
    void onCustomerContactsClicked(MouseEvent event) {

    }

    @FXML
    void onDispatchTruckClick(ActionEvent event) {

    }

    @FXML
    void onNewConsignmentClick(MouseEvent event) throws Exception {
        scrollPane.setContent(FXMLLoader.load(getClass().getResource("newConsignment.fxml")));
    }

    @FXML
    void onPrintBillClicked(MouseEvent event) {

    }

    @FXML
    void onReceiveTruckClick(MouseEvent event) {

    }

    @FXML
    void onTodoListClicked(MouseEvent event) {

    }

}
