package com.ayushtiwari.EmployeeUI;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class IndividualTruckReceiveController {

    private String truckIdValue;

    @FXML
    private Label truckID;

    @FXML
    private Label occupancy;

    @FXML
    private Label capacity;

    @FXML
    private Label dispatchingBranch;

    @FXML
    private JFXButton receiveTruck;

    @FXML
    private TableView<RDConsignmentTableItem> tableView;

    @FXML
    private TableColumn<RDConsignmentTableItem, String> consignmentId;

    @FXML
    private TableColumn<RDConsignmentTableItem, String> volume;

    public void initialize() {

        consignmentId.setCellValueFactory(new PropertyValueFactory<>("consignmentId"));
        volume.setCellValueFactory(new PropertyValueFactory<>("volume"));

        tableView.setItems(populate());

        /*
         *
         */

    }

    public ObservableList<RDConsignmentTableItem> populate() {

        ObservableList<RDConsignmentTableItem> observableList = FXCollections.observableArrayList();
        /*
         *   Query Database and populate
         */

        return observableList;

    }

    public void initData(String truckIdValue) {
        this.truckIdValue = truckIdValue;
    }
}
