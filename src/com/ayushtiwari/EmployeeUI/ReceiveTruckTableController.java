package com.ayushtiwari.EmployeeUI;

import com.ayushtiwari.TransportCompanyData.TransportData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.*;

public class ReceiveTruckTableController {

    @FXML
    private TableView<ReceiveTruckTableItem> tableView;

    @FXML
    private TableColumn<ReceiveTruckTableItem, String> truckID;

    @FXML
    private TableColumn<ReceiveTruckTableItem, String> departingBranch;

    @FXML
    private TableColumn<ReceiveTruckTableItem, String> expectedArrivalDate;

    @FXML
    private TableColumn<ReceiveTruckTableItem, String> occupancy;

    @FXML
    private TableColumn<ReceiveTruckTableItem, String> driverId;

    public void initialize() {
        truckID.setCellValueFactory(new PropertyValueFactory<>("truckId"));
        departingBranch.setCellValueFactory(new PropertyValueFactory<>("sendingBranch"));
        occupancy.setCellValueFactory(new PropertyValueFactory<>("volumeFilled"));

        tableView.setItems(populate());

        tableView.setRowFactory(tv -> {
            TableRow<ReceiveTruckTableItem> row = new TableRow<>();

            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    ReceiveTruckTableItem tableItem = row.getItem();
                    try {

                        System.out.println("Truck id = " + tableItem.getTruckId());

                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("individualTruckReceive.fxml"));
                        Parent individualScene = loader.load();

                        System.out.println("Truck id = " + tableItem.getTruckId());

                        Scene individual = new Scene(individualScene);

                        IndividualTruckReceiveController controller = loader.getController();

                        System.out.println("Truck id = " + tableItem.getTruckId());

                        controller.initData(Integer.parseInt(tableItem.getTruckId()));

                        Stage stage = new Stage();
                        stage.initModality(Modality.WINDOW_MODAL);
                        stage.setScene(individual);
                        stage.show();

                    } catch (Exception e) {
                        System.out.println("Error");
                    }
                }

            });
            return row;
        });

    }

    private ObservableList<ReceiveTruckTableItem> populate() {

        ObservableList<ReceiveTruckTableItem> observableList = FXCollections.observableArrayList();

        int branchId = TransportData.getInstance().getOfficeId();
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/TransportDatabase.db");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Trucks WHERE nextBranchID=" + branchId);


            while (resultSet.next()) {

                if (!resultSet.getString("departureTime").equals("*"))

                    observableList.add(

                            new ReceiveTruckTableItem(
                                    resultSet.getInt("_id") + "",
                                    resultSet.getInt("currentBranchID") + "",
                                    resultSet.getInt("currentOccupancy") + ""
                            )
                    );

            }

        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        return observableList;


    }

}
