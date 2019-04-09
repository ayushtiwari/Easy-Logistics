
package com.ayushtiwari.EmployeeUI;

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

                        controller.initData(tableItem.getTruckId());

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

    public ObservableList<DispatchTruckTableItem> populate() {

        ObservableList<DispatchTruckTableItem> observableList = FXCollections.observableArrayList();

        /*

        Query database
         */

        return observableList;

    }

}
