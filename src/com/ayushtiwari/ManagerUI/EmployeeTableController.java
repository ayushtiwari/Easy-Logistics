package com.ayushtiwari.ManagerUI;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class EmployeeTableController {

    @FXML
    private TableView<EmployeeTableItem> tableView;

    @FXML
    private TableColumn<EmployeeTableItem, String> employeeIdColumn;

    @FXML
    private TableColumn<EmployeeTableItem, String> employeeNameColumn;

    @FXML
    private TableColumn<EmployeeTableItem, String> branchColumn;

    @FXML
    private TableColumn<EmployeeTableItem, String> userNameColumn;

    @FXML
    private TableColumn<EmployeeTableItem, String> password;

    public void initialize() {
        employeeIdColumn.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        employeeNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        branchColumn.setCellValueFactory(new PropertyValueFactory<>("branch"));
        userNameColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));

        tableView.setItems(populate());
    }

    public ObservableList<EmployeeTableItem> populate() {

        ObservableList<EmployeeTableItem> observableList = FXCollections.observableArrayList();


        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/TransportDatabase.db");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Employees");

            while (resultSet.next()) {

                observableList.add(new EmployeeTableItem(
                        resultSet.getString("name"),
                        resultSet.getString("branchId"),
                        resultSet.getString("_id"),
                        resultSet.getString("userName"),
                        resultSet.getString("password")
                ));

            }

        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
        }
        return observableList;
    }

}
