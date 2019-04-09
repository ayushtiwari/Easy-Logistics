
package com.ayushtiwari.EmployeeUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DispatchTruckTableController {

    @FXML
    private TableView<DispatchTruckTableItem> tableView;

    @FXML
    private TableColumn<DispatchTruckTableItem, String> truckID;

    @FXML
    private TableColumn<DispatchTruckTableItem, String> destinationBranch;

    @FXML
    private TableColumn<DispatchTruckTableItem, String> Capacity;

    @FXML
    private TableColumn<DispatchTruckTableItem, String> occupancy;

    @FXML
    private TableColumn<DispatchTruckTableItem, String> driverId;

    public void initialize() {
        truckID.setCellValueFactory(new PropertyValueFactory<>("truckId"));
        destinationBranch.setCellValueFactory(new PropertyValueFactory<>("destinationBranch"));
        Capacity.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        occupancy.setCellValueFactory(new PropertyValueFactory<>("occupancy"));

        tableView.setItems(populate());
    }

    public ObservableList<DispatchTruckTableItem> populate() {

        ObservableList<DispatchTruckTableItem> observableList = FXCollections.observableArrayList();

        /*

        Query database
         */

        return observableList;

    }

}
