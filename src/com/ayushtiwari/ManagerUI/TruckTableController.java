package com.ayushtiwari.ManagerUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TruckTableController {

    @FXML
    private TableView<TruckTableItem> tableView;

    @FXML
    private TableColumn<TruckTableItem, String> truckID;

    @FXML
    private TableColumn<TruckTableItem, String> departingBranch;

    @FXML
    private TableColumn<TruckTableItem, String> averageTruckIdleTime;

    @FXML
    private TableColumn<TruckTableItem, String> occupancy;

    @FXML
    private TableColumn<TruckTableItem, String> capacity;

    public void initialize() {
        truckID.setCellValueFactory(new PropertyValueFactory<>("truckId"));
        departingBranch.setCellValueFactory(new PropertyValueFactory<>("currentBranch"));
        averageTruckIdleTime.setCellValueFactory(new PropertyValueFactory<>("averageTruckIdleTime"));
        occupancy.setCellValueFactory(new PropertyValueFactory<>("occupancy"));
        capacity.setCellValueFactory(new PropertyValueFactory<>("capacity"));

        tableView.setItems(populate());
    }

    public ObservableList<TruckTableItem> populate() {
        ObservableList<TruckTableItem> observableList = FXCollections.observableArrayList();
        /*
         *   Query Database
         */
        return observableList;
    }

}
