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

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TrasportCompany/database1.db");
            Statement st = conn.createStatement();
            st.execute("SELECT * FROM office");
            ResultSet results = st.getResultSet();
            String consignmentList = "*";
            while (results.next()) {
                if (TransportData.getInstance().getOfficeId() == results.getInt(1))
                    consignmentList = results.getString(6);
            }
            st.execute("SELECT * FROM consignment");
            ResultSet results1 = st.getResultSet();


            if (consignmentList.equals("*")) {

            } else {
                String[] consignments = consignmentList.substring(1).split(",");
                while (results1.next()) {

                    boolean flag = false;

                    for (String i : consignments) {
                        if (Integer.toString(results1.getInt(1)).equals(i)) {
                            flag = true;
                            break;
                        }
                    }

                    if (flag) {
                        System.out.println(results1.getInt(1));     //consignemntidd
                        System.out.println(results1.getString(3));  //sendername
                        System.out.println(results1.getString(9));  //dispatch status
                        System.out.println(results1.getString(10));  //deliverystatus
                        System.out.println(results1.getString(14)); //sendingofficeid
                        System.out.println(results1.getString(15)); //receivingofficeid
                        System.out.println(results1.getString(5));  //sender city
                        System.out.println(results1.getString(8));  //receiver city

                    }
                }

            }
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }

        return consignmentTableItemObservableList;
    }


}
