package com.ayushtiwari.ManagerUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

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


        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/database1-2.db");
            Statement st = conn.createStatement();
            st.execute("SELECT * FROM truck");
            ResultSet results = st.getResultSet();
            Statement st1 = conn.createStatement();
            st1.execute("SELECT * FROM office");
            ResultSet results1 = st1.getResultSet();

            int truckid;
            int dispatchingBranchId;
            int currOccupancy;
            int idleHours;
            int idleMinutes;
            int maxCapacity;
            String cityName = "";

            while (results.next()) {
                truckid = results.getInt(1); //truckid
                dispatchingBranchId = results.getInt(3); //dispatching branchid
                currOccupancy = results.getInt(11); //curr_occupamcy
                idleHours = results.getInt(5);//
                idleMinutes = results.getInt(6);//
                maxCapacity = results.getInt(4); //max_capacity

                int branchid = results.getInt(3);

                while (results1.next()) {
                    if (results1.getInt(1) == branchid) {
                        cityName = results1.getString(4);//cityname
                    }
                }


                observableList.add(new TruckTableItem(truckid, idleHours, idleMinutes, branchid, cityName, currOccupancy, maxCapacity));

                st1.execute("SELECT * FROM office");
                results1 = st1.getResultSet();


            }
        } catch (SQLException e) {
            System.out.println("Something went wrong" + e.getMessage());
        }
        return observableList;
    }

}
