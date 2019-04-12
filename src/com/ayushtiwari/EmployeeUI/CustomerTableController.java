package com.ayushtiwari.EmployeeUI;

import com.ayushtiwari.TransportCompanyData.TransportData;
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
        int branchid = TransportData.getInstance().getOfficeId();
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/TransportDatabase.db");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT Customers.name, Customers.street, Customers.city, Customers.consignmentId FROM Customers " +
                    "INNER JOIN Consignments ON Customers.consignmentId=Consignments._id WHERE Consignments.senderId=" + branchid);

            while (resultSet.next()) {
                observableList.add(new CustomerTableItem(resultSet.getString("name"), resultSet.getString("street"), resultSet.getString("city"), resultSet.getString("consignmentId")));
            }

        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }

        return observableList;
    }

}
