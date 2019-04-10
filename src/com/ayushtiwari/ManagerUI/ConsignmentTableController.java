
package com.ayushtiwari.ManagerUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class ConsignmentTableController {

    @FXML
    private TableView<ConsignmentTableItem> tableView;

    @FXML
    private TableColumn<ConsignmentTableItem, String> consignmentIdColumn;

    @FXML
    private TableColumn<ConsignmentTableItem, String> senderNameColumn;

    @FXML
    private TableColumn<ConsignmentTableItem, String> sendingOfficeColumn;

    @FXML
    private TableColumn<ConsignmentTableItem, String> receivingOfficeColumn;

    @FXML
    private TableColumn<ConsignmentTableItem, String> arrivalTime;

    @FXML
    private TableColumn<ConsignmentTableItem, String> dispatchTime;

    public void initialize() {

        consignmentIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        senderNameColumn.setCellValueFactory(new PropertyValueFactory<>("sendersName"));
        sendingOfficeColumn.setCellValueFactory(new PropertyValueFactory<>("sendingOfficeId"));
        receivingOfficeColumn.setCellValueFactory(new PropertyValueFactory<>("receivingOfficeId"));
        arrivalTime.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));
        dispatchTime.setCellValueFactory(new PropertyValueFactory<>("dispatchTime"));

        tableView.setItems(populate());

    }

    public ObservableList<ConsignmentTableItem> populate() {

        ObservableList<ConsignmentTableItem> observableList = FXCollections.observableArrayList();

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/database1-2.db");
            Statement st = conn.createStatement();
            st.execute("SELECT * FROM consignment");
            ResultSet results = st.getResultSet();
            System.out.println("AlphaBetaGamma");
            while (results.next()) {
                System.out.println(results.getInt(1));//consignment_id
                System.out.println(results.getInt(2));//volume
                System.out.println(results.getString(3));//senders name
                System.out.println(results.getString(11));//arrival time
                System.out.println(results.getString(12));//departure time
                System.out.println(results.getInt(14));//sending officeid
                System.out.println(results.getInt(15));//recieving officeid


                observableList.add(
                        new ConsignmentTableItem(
                                Integer.toString(results.getInt(1)),
                                results.getString(3),
                                Integer.toString(results.getInt(14)),
                                Integer.toString(results.getInt(15)),
                                results.getString(11),
                                results.getString(12)
                        )
                );

            }
        } catch (SQLException e) {
            System.out.println("something went wrong");
        }

        return observableList;

    }

}
