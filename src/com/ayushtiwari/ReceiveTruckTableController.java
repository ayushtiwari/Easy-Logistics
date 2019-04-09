package com.ayushtiwari;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ReceiveTruckTableController {

    @FXML
    private TableView<ReceiveTruckTableItem> tableView;

    @FXML
    private TableColumn<ReceiveTruckTableItem, String> truckID;

    @FXML
    private TableColumn<ReceiveTruckTableItem, String> departingBranch;

    @FXML
    private TableColumn<ReceiveTruckTableItem, String> expectedArrivalDate;

    @FXML
    private TableColumn<ReceiveTruckTableItem, String> occupancy;

    @FXML
    private TableColumn<ReceiveTruckTableItem, String> driverId;

    public void initialize() {
        truckID.setCellValueFactory(new PropertyValueFactory<>("truckId"));
        departingBranch.setCellValueFactory(new PropertyValueFactory<>("sendingBranch"));
        occupancy.setCellValueFactory(new PropertyValueFactory<>("volumeFilled"));

        tableView.setItems(populate());

    }

    private ObservableList<ReceiveTruckTableItem> populate() {

        ObservableList<ReceiveTruckTableItem> observableList = FXCollections.observableArrayList();

        //Query Database and return ObservableList

        return observableList;

    }

}
