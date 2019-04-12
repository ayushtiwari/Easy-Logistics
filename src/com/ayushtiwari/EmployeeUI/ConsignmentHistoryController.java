package com.ayushtiwari.EmployeeUI;

import com.ayushtiwari.TransportCompanyData.TransportData;
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
import java.sql.*;
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

    private int consignmentId = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        consignmentIdColumn.setCellValueFactory(new PropertyValueFactory<ConsignmentTableItem, String>("id"));
        senderNameColumn.setCellValueFactory(new PropertyValueFactory<ConsignmentTableItem, String>("sendersName"));
        receivingOfficeColumn.setCellValueFactory(new PropertyValueFactory<ConsignmentTableItem, String>("receivingOfficeId"));
        sendingOfficeColumn.setCellValueFactory(new PropertyValueFactory<ConsignmentTableItem, String>("sendingOfficeId"));
        dispatchStatusColumn.setCellValueFactory(new PropertyValueFactory<ConsignmentTableItem, String>("isDispatched"));
        deliveryStatusColumn.setCellValueFactory(new PropertyValueFactory<ConsignmentTableItem, String>("isDelivered"));



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

                        controller.initData(Integer.parseInt(tableItem.getId()));

                        Stage stage = new Stage();
                        stage.setScene(individual);
                        stage.setTitle("Consignment ID : " + tableItem.getId());
                        stage.setResizable(false);
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

        int branchid = TransportData.getInstance().getOfficeId();

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/TransportDatabase.db");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Consignments WHERE senderId=" + branchid + " OR receiverId=" + branchid + " ORDER BY _id DESC");

            while (resultSet.next()) {

                Statement statement1 = connection.createStatement();
                ResultSet resultSet1 = statement1.executeQuery("SELECT * FROM Customers WHERE consignmentId=" + resultSet.getInt("_id"));


                String delivaryStatus = "";
                String dispatchStatus = "";

                if (resultSet.getString("deliveryTime").equals("*")) delivaryStatus = "Not Yet Delivered";
                else delivaryStatus = "Delivered";

                if (resultSet.getString("dispatchTime").equals("*")) dispatchStatus = "Not Yet Dispatched";
                else dispatchStatus = "Dispatched";

                consignmentTableItemObservableList.add(


                        new ConsignmentTableItem(
                                resultSet.getInt("_id") + "",
                                resultSet1.getString("name"),
                                Integer.toString(resultSet.getInt("senderId")),
                                Integer.toString(resultSet.getInt("receiverId")),
                                delivaryStatus,
                                dispatchStatus
                        )
                );

            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }

        return consignmentTableItemObservableList;
    }


}
