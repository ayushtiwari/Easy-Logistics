package com.ayushtiwari;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

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

    public void initialize() throws Exception {
        scrollPane.setContent((FXMLLoader.load(getClass().getResource("welcome.fxml"))));
    }

    @FXML
    void onConsignmentHistoryClicked(MouseEvent event) throws Exception {
        scrollPane.setContent(FXMLLoader.load(getClass().getResource("consignmentHistory.fxml")));
        consignmentHistory.setTextFill(Color.rgb(150, 150, 150, 1));
        dispatchTruck.setTextFill(Color.WHITE);
        printBill.setTextFill(Color.WHITE);
        newConsignment.setTextFill(Color.WHITE);
        customerContacts.setTextFill(Color.WHITE);
        receiveTruck.setTextFill(Color.WHITE);
    }

    @FXML
    void onCustomerContactsClicked(MouseEvent event) {
        consignmentHistory.setTextFill(Color.WHITE);
        dispatchTruck.setTextFill(Color.WHITE);
        printBill.setTextFill(Color.WHITE);
        newConsignment.setTextFill(Color.WHITE);
        customerContacts.setTextFill(Color.rgb(150, 150, 150, 1));
        receiveTruck.setTextFill(Color.WHITE);
    }

    @FXML
    void onDispatchTruckClick(ActionEvent event) {
        consignmentHistory.setTextFill(Color.WHITE);
        dispatchTruck.setTextFill(Color.rgb(150, 150, 150, 1));
        printBill.setTextFill(Color.WHITE);
        newConsignment.setTextFill(Color.WHITE);
        customerContacts.setTextFill(Color.WHITE);
        receiveTruck.setTextFill(Color.WHITE);
    }

    @FXML
    void onNewConsignmentClick(MouseEvent event) throws Exception {
        scrollPane.setContent(FXMLLoader.load(getClass().getResource("newConsignment.fxml")));
        consignmentHistory.setTextFill(Color.WHITE);
        dispatchTruck.setTextFill(Color.WHITE);
        printBill.setTextFill(Color.WHITE);
        newConsignment.setTextFill(Color.rgb(150, 150, 150, 1));
        customerContacts.setTextFill(Color.WHITE);
        receiveTruck.setTextFill(Color.WHITE);
    }

    @FXML
    void onPrintBillClicked(MouseEvent event) {
        consignmentHistory.setTextFill(Color.WHITE);
        dispatchTruck.setTextFill(Color.WHITE);
        printBill.setTextFill(Color.rgb(150, 150, 150, 1));
        newConsignment.setTextFill(Color.WHITE);
        customerContacts.setTextFill(Color.WHITE);
        receiveTruck.setTextFill(Color.WHITE);

    }

    @FXML
    void onReceiveTruckClick(MouseEvent event) {
        consignmentHistory.setTextFill(Color.WHITE);
        dispatchTruck.setTextFill(Color.WHITE);
        printBill.setTextFill(Color.WHITE);
        newConsignment.setTextFill(Color.WHITE);
        customerContacts.setTextFill(Color.WHITE);
        receiveTruck.setTextFill(Color.rgb(150, 150, 150, 1));

    }

    @FXML
    void onTodoListClicked(MouseEvent event) {
        consignmentHistory.setTextFill(Color.WHITE);
        dispatchTruck.setTextFill(Color.WHITE);
        printBill.setTextFill(Color.WHITE);
        newConsignment.setTextFill(Color.WHITE);
        customerContacts.setTextFill(Color.WHITE);
        receiveTruck.setTextFill(Color.WHITE);

    }

}
