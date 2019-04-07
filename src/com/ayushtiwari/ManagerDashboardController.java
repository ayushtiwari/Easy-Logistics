package com.ayushtiwari;


import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ManagerDashboardController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private JFXButton addNewBranch;

    @FXML
    private JFXButton addNewTruck;

    @FXML
    private JFXButton addNewEmployee;

    @FXML
    private JFXButton viewConsignments;

    @FXML
    private JFXButton viewBranchStats;

    @FXML
    private JFXButton viewTruckStatus;

    @FXML
    private JFXButton viewEmployeeDetails;

    @FXML
    private JFXButton viewCustomerDetails;


    @FXML
    void onAddNewBranchClick(MouseEvent event) throws Exception {
        scrollPane.setContent(FXMLLoader.load(getClass().getResource("newBranch.fxml")));
    }

    @FXML
    void onAddNewEmployeeClick(MouseEvent event) throws Exception {
        scrollPane.setContent((FXMLLoader.load((getClass().getResource("newEmployee.fxml")))));
    }

    @FXML
    void onAddNewTruckClick(MouseEvent event) throws Exception {
        scrollPane.setContent(FXMLLoader.load(getClass().getResource("newTruck.fxml")));
    }

    @FXML
    void onViewBranchStatsClick(MouseEvent event) {

    }

    @FXML
    void onViewConsignmentsClick(MouseEvent event) {

    }

    @FXML
    void onViewCustomerDetailsClick(MouseEvent event) {

    }

    @FXML
    void onViewEmployeeDetailsClick(MouseEvent event) {

    }

    @FXML
    void onViewTruckStatusClick(MouseEvent event) {

    }

    @FXML
    void initialize() throws Exception {
        scrollPane.setContent(FXMLLoader.load(getClass().getResource("welcome.fxml")));
    }
}
