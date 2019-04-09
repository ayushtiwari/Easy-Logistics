package com.ayushtiwari.ManagerUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CustomerTableController {

    @FXML
    private TableView<CustomerTableItem> tableView;

    @FXML
    private TableColumn<CustomerTableItem, String> customerName;

    @FXML
    private TableColumn<CustomerTableItem, String> customerStreetName;

    @FXML
    private TableColumn<CustomerTableItem, String> customerCityName;

    @FXML
    private TableColumn<CustomerTableItem, String> consignmentId;

    public void initialize() {
        customerName.setCellValueFactory(new PropertyValueFactory<>("name"));
        customerCityName.setCellValueFactory(new PropertyValueFactory<>("cityName"));
        customerStreetName.setCellValueFactory(new PropertyValueFactory<>("streetName"));

        tableView.setItems(populate());
    }

    public ObservableList<CustomerTableItem> populate() {
        ObservableList<CustomerTableItem> observableList = FXCollections.observableArrayList();
        /*
         *   Query database
         *   Get List of all customers from database
         */
        return observableList;
    }

}
