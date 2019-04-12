package com.ayushtiwari.EmployeeUI;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class IndividualTruckDispatchController {

    private int truckIdValue = 0;

    @FXML
    private Label truckID;

    @FXML
    private Label occupancy;

    @FXML
    private Label capacity;

    @FXML
    private Label destinationBranch;

    @FXML
    private JFXButton dispatchTruck;

    @FXML
    private TableView<RDConsignmentTableItem> tableView;

    @FXML
    private TableColumn<RDConsignmentTableItem, String> consignmentId;

    @FXML
    private TableColumn<RDConsignmentTableItem, String> volume;

    public void initialize() {

    }

    public ObservableList<RDConsignmentTableItem> populate() {
        ObservableList<RDConsignmentTableItem> observableList = FXCollections.observableArrayList();

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/TransportDatabase.db");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Consignments WHERE truckId=" + truckIdValue);

            while (resultSet.next()) {
                observableList.add(new RDConsignmentTableItem(Integer.toString(resultSet.getInt("_id")), Integer.toString(resultSet.getInt("volume"))));
            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }

        return observableList;
    }

    public void initData(int truckIdValue) {

        consignmentId.setCellValueFactory(new PropertyValueFactory<>("consignmentId"));
        volume.setCellValueFactory(new PropertyValueFactory<>("volume"));
        this.truckIdValue = truckIdValue;

        truckID.setText(truckIdValue + "");
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/TransportDatabase.db");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Trucks WHERE _id=" + truckIdValue);

            truckID.setText(resultSet.getInt("_id") + "");
            destinationBranch.setText(resultSet.getInt("nextBranchID") + "");
            occupancy.setText(resultSet.getInt("currentOccupancy") + "");
            capacity.setText(resultSet.getInt("capacity") + "");

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        tableView.setItems(populate());

    }


    @FXML
    public void onDispatchClicked(ActionEvent event) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/TransportDatabase.db");
            Statement statement = connection.createStatement();

            System.out.println("a");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Trucks WHERE _id=" + truckIdValue);

            LocalDateTime arrivalTime = LocalDateTime.parse(resultSet.getString("arrivalTime"));
            LocalDateTime departureTime = LocalDateTime.now();

            long minutes = ChronoUnit.MINUTES.between(arrivalTime, departureTime);

            long averageIdleTime = resultSet.getInt("averageIdleTime") + minutes;

            statement.executeUpdate("UPDATE Trucks SET departureTime='" + departureTime.toString() + "', averageIdleTime=" + averageIdleTime + " WHERE _id=" + truckIdValue);

            statement.executeUpdate("UPDATE Consignments SET dispatchTime='" + LocalDateTime.now().toString() + "'" + " WHERE truckId=" + truckIdValue);


            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Details Updated Succesfully.Please Refresh.");
            alert.setTitle("Success");
            alert.showAndWait();


            resultSet.close();
            statement.close();
            connection.close();


        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }

    }


}
