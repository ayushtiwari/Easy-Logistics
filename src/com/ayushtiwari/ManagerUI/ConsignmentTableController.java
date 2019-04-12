
package com.ayushtiwari.ManagerUI;

import com.ayushtiwari.EmployeeUI.IndividualConsignmentDisplayController;
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
import javafx.stage.Stage;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

        tableView.setRowFactory(tv -> {
            TableRow<com.ayushtiwari.ManagerUI.ConsignmentTableItem> row = new TableRow<>();

            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    com.ayushtiwari.ManagerUI.ConsignmentTableItem tableItem = row.getItem();
                    try {


                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("../EmployeeUI/individualConsignmentDisplay.fxml"));
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

    public ObservableList<ConsignmentTableItem> populate() {

        ObservableList<ConsignmentTableItem> observableList = FXCollections.observableArrayList();

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/TransportDatabase.db");
            Statement st = conn.createStatement();
            st.execute("SELECT * FROM Consignments");
            ResultSet results = st.getResultSet();
            System.out.println("AlphaBetaGamma");
            while (results.next()) {

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT name FROM Customers WHERE consignmentId=" + results.getInt("_id"));

                LocalDateTime arrival = LocalDateTime.parse(results.getString("arrivalTime"));
                LocalDateTime dispatch = LocalDateTime.parse(results.getString("dispatchTime"));


                //Create formatter
                DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm a");

//

                String arrivalT = arrival.format(FOMATTER);
                String departT = dispatch.format(FOMATTER);

                observableList.add(
                        new ConsignmentTableItem(
                                Integer.toString(results.getInt("_id")),
                                resultSet.getString("name"),
                                Integer.toString(results.getInt("senderId")),
                                Integer.toString(results.getInt("receiverId")),
                                arrivalT,
                                departT
                        )
                );

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return observableList;

    }

}
