package com.ayushtiwari.ManagerUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class BranchStatsController {

    @FXML
    private TableView<BranchStatsTableItem> tableView;

    @FXML
    private TableColumn<BranchStatsTableItem, String> branchID;

    @FXML
    private TableColumn<BranchStatsTableItem, String> streetName;

    @FXML
    private TableColumn<BranchStatsTableItem, String> cityName;

    @FXML
    private TableColumn<BranchStatsTableItem, String> employeeCount;


    public void initialize() {

        branchID.setCellValueFactory(new PropertyValueFactory<>("branchId"));
        streetName.setCellValueFactory(new PropertyValueFactory<>("streetName"));
        cityName.setCellValueFactory(new PropertyValueFactory<>("cityName"));
        employeeCount.setCellValueFactory(new PropertyValueFactory<>("noOfEmployees"));

        tableView.setItems(populate());


    }

    public ObservableList<BranchStatsTableItem> populate() {
        ObservableList<BranchStatsTableItem> observableList = FXCollections.observableArrayList();

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/TransportDatabase.db");
            Statement st = conn.createStatement();
            st.execute("SELECT * FROM Offices");
            ResultSet results = st.getResultSet();


            while (results.next()) {
                System.out.println("alpha");

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Employees WHERE branchId=" + results.getInt(1));

                System.out.println("alpha");
                int empCount = 0;

                while (resultSet.next()) empCount++;

                System.out.println("alpha");

                observableList.add(new BranchStatsTableItem(Integer.toString(results.getInt("_id")), results.getString("street"), results.getString("city"), Integer.toString(empCount)));

                System.out.println("alpha");
                resultSet.close();
                statement.close();
            }

            results.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return observableList;

    }

}
