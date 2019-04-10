package com.ayushtiwari.ManagerUI;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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

    public void initialize() {
        employeeIdColumn.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        employeeNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        branchColumn.setCellValueFactory(new PropertyValueFactory<>("branch"));
        userNameColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));

        tableView.setItems(populate());
    }

    public ObservableList<EmployeeTableItem> populate() {

        ObservableList<EmployeeTableItem> observableList = FXCollections.observableArrayList();

        String employeeIdValue, nameValue, branchValue, userNameValue, cityName = "";

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/database1-2.db");
            Statement st = conn.createStatement();
            st.execute("SELECT * FROM employee");
            ResultSet results = st.getResultSet();
            Statement st1 = conn.createStatement();
            st1.execute("SELECT * FROM office");
            ResultSet results1 = st1.getResultSet();
            while (results.next()) {
                employeeIdValue = Integer.toString(results.getInt(1));
//                System.out.println(results.getInt(1));   //employee id
                nameValue = results.getString(2);  //employee name
                branchValue = Integer.toString(results.getInt(3)); //branch_id
                userNameValue = results.getString(4); //username

                int branchid = results.getInt(3);

                while (results1.next()) {
                    if (results1.getInt(1) == branchid) {
                        cityName = results1.getString(4);//cityname
                    }
                }

                observableList.add(new EmployeeTableItem(nameValue, branchid + " - " + cityName, employeeIdValue, userNameValue));

                st1.execute("SELECT * FROM office");
                results1 = st1.getResultSet();
            }
            st.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong" + e.getMessage());
        }
        return observableList;
    }

}
