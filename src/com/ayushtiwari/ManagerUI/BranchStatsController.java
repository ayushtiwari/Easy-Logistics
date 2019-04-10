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
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/database1-2.db");
            Statement st = conn.createStatement();
            st.execute("SELECT * FROM office");
            ResultSet results = st.getResultSet();
            while (results.next()) {
                String b = Integer.toString(results.getInt(1));
                System.out.println(results.getString(2));
                String x = results.getString(3);   //street name
                String y = results.getString(4);   //city name
                String z = results.getString(2);

                if (z.equals("*")) {
                    observableList.add(new BranchStatsTableItem("Office No : " + b, x, y, "0"));

                } else {
                    observableList.add(new BranchStatsTableItem("Office No : " + b, x, y, Integer.toString(z.split(",").length)));
                }


            }
        } catch (SQLException e) {
            System.out.println("something went wrong");
        }


        return observableList;

    }

}
