
package com.ayushtiwari.EmployeeUI;

import com.ayushtiwari.TransportCompanyData.TransportData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.*;

public class DispatchTruckTableController {

    @FXML
    private TableView<DispatchTruckTableItem> tableView;

    @FXML
    private TableColumn<DispatchTruckTableItem, String> truckID;

    @FXML
    private TableColumn<DispatchTruckTableItem, String> destinationBranch;

    @FXML
    private TableColumn<DispatchTruckTableItem, String> Capacity;

    @FXML
    private TableColumn<DispatchTruckTableItem, String> occupancy;

    @FXML
    private TableColumn<DispatchTruckTableItem, String> driverId;

    public void initialize() {
        truckID.setCellValueFactory(new PropertyValueFactory<>("truckId"));
        destinationBranch.setCellValueFactory(new PropertyValueFactory<>("destinationBranch"));
        Capacity.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        occupancy.setCellValueFactory(new PropertyValueFactory<>("occupancy"));

        tableView.setItems(populate());

        tableView.setRowFactory(tv -> {
            TableRow<DispatchTruckTableItem> row = new TableRow<>();

            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    DispatchTruckTableItem tableItem = row.getItem();
                    try {


                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("individualTruckDispatch.fxml"));
                        Parent individualScene = loader.load();

                        Scene individual = new Scene(individualScene);

                        IndividualTruckDispatchController controller = loader.getController();
                        System.out.println("Truck Id = " + tableItem.getTruckId());
                        controller.initData(Integer.parseInt(tableItem.getTruckId()));


                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        Stage stage = new Stage();
                        stage.initOwner(window);


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

    public ObservableList<DispatchTruckTableItem> populate() {

        int branchId = TransportData.getInstance().getOfficeId();

        ObservableList<DispatchTruckTableItem> observableList = FXCollections.observableArrayList();


        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/TransportDatabase.db");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Trucks WHERE currentBranchID=" + branchId + " AND currentOccupancy>0 AND departureTime='*'");


            while (resultSet.next()) {


                observableList.add(
                        new DispatchTruckTableItem(
                                resultSet.getInt("_id") + "",
                                resultSet.getInt("nextBranchID") + "",
                                resultSet.getInt("capacity") + "",
                                resultSet.getInt("currentOccupancy") + ""
                        )
                );

            }

        } catch (SQLException se) {
            System.out.println(se.getMessage()
            );
        }

        return observableList;

    }

}
