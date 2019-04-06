package com.ayushtiwari;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class ConsignmentHistoryController implements Initializable {

    @FXML
    private TableView<ConsignmentTableItem> tableView;
    @FXML
    private TableColumn<ConsignmentTableItem, String> consignmentIdColumn;
    @FXML
    private TableColumn<ConsignmentTableItem, String> senderNameColumn;
    @FXML
    private TableColumn<ConsignmentTableItem, String> receivingOfficeColumn;
    @FXML
    private TableColumn<ConsignmentTableItem, String> sendingOfficeColumn;
    @FXML
    private TableColumn<ConsignmentTableItem, String> dispatchStatusColumn;
    @FXML
    private TableColumn<ConsignmentTableItem, String> deliveryStatusColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        consignmentIdColumn.setCellValueFactory(new PropertyValueFactory<ConsignmentTableItem, String>("id"));
        senderNameColumn.setCellValueFactory(new PropertyValueFactory<ConsignmentTableItem, String>("sendersName"));
        receivingOfficeColumn.setCellValueFactory(new PropertyValueFactory<ConsignmentTableItem, String>("receivingOfficeId"));
        sendingOfficeColumn.setCellValueFactory(new PropertyValueFactory<ConsignmentTableItem, String>("sendingOfficeId"));
        dispatchStatusColumn.setCellValueFactory(new PropertyValueFactory<ConsignmentTableItem, String>("isDispatched"));
        deliveryStatusColumn.setCellValueFactory(new PropertyValueFactory<ConsignmentTableItem, String>("isDelivered"));

        //load dummy data

        tableView.setItems(getConsignments());


        tableView.setRowFactory(tv -> {
            TableRow<ConsignmentTableItem> row = new TableRow<>();

            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    ConsignmentTableItem tableItem = row.getItem();
                    try {


                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("individualConsignmentDisplay.fxml"));
                        Parent individualScene = loader.load();

                        Scene individual = new Scene(individualScene);

                        IndividualConsignmentDisplayController controller = loader.getController();

                        //Query Database get Consignment by consignment Id

                        controller.initData(2);

                        Stage stage = new Stage();
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

    public ObservableList<ConsignmentTableItem> getConsignments() {
        ObservableList<ConsignmentTableItem> consignmentTableItemObservableList = FXCollections.observableArrayList();
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("5678", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        consignmentTableItemObservableList.add(new ConsignmentTableItem("1234", "alpha", "beta", "gamma", "delta", "empsion"));
        return consignmentTableItemObservableList;
    }


}
