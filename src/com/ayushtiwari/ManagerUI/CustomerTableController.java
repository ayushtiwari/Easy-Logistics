package com.ayushtiwari.ManagerUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

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
        consignmentId.setCellValueFactory(new PropertyValueFactory<>("consignmentId"));
        tableView.setItems(populate());
    }

    public ObservableList<CustomerTableItem> populate() {
        ObservableList<CustomerTableItem> observableList = FXCollections.observableArrayList();


        try {

            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/TransportDatabase.db");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Customers");
            while (resultSet.next()) {
                observableList.add(new CustomerTableItem(
                        resultSet.getString("name"),
                        resultSet.getString("street"),
                        resultSet.getString("city"),
                        Integer.toString(resultSet.getInt("consignmentId"))
                ));
            }

        } catch (SQLException se) {

        }


        return observableList;
    }

}
