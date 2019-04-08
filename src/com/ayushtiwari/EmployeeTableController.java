package com.ayushtiwari;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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

    public void initialize() {
        employeeIdColumn.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        employeeNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        branchColumn.setCellValueFactory(new PropertyValueFactory<>("branch"));
        userNameColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));

        tableView.setItems(populate());
    }

    public ObservableList<EmployeeTableItem> populate() {

        ObservableList<EmployeeTableItem> observableList = FXCollections.observableArrayList();

        //populate using database

        return observableList;
    }

}
