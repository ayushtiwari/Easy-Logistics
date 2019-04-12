package com.ayushtiwari.EmployeeUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class IndividualConsignmentDisplayController implements Initializable {

    private int consignment = 0;

    @FXML
    private Label consignmentId;

    @FXML
    private Label date;

    @FXML
    private Label dispatchingBranch;

    @FXML
    private Label receivingBranch;

    @FXML
    private Label senderName;

    @FXML
    private Label senderAddress;

    @FXML
    private Label receiverName;

    @FXML
    private Label receiverAddress;

    @FXML
    private Label volume;

    @FXML
    private Label truckAlloted;


    @FXML
    private Label dispatchDate;

    @FXML
    private Label dispatchTime;

    @FXML
    private Label deliveryStatus;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void initData(int consignmentID) {
        this.consignment = consignmentID;

        System.out.println(consignment);

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/TransportDatabase.db");

            System.out.println("a");

            Statement statement = connection.createStatement();

            System.out.println("b");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Consignments WHERE _id=" + consignment);

            System.out.println("c");

            Statement statement1 = connection.createStatement();

            System.out.println("d");

            ResultSet resultSet1 = statement1.executeQuery("SELECT * FROM Customers WHERE consignmentId=" + consignment);

            System.out.println("e");

            consignmentId.setText(resultSet.getInt("_id") + "");
            date.setText(resultSet.getString("arrivalTime").split("T")[0]);
            dispatchingBranch.setText(resultSet.getInt("senderId") + "");
            receivingBranch.setText(resultSet.getInt("receiverId") + "");
            senderName.setText(resultSet1.getString("name"));
            senderAddress.setText(resultSet1.getString("street") + resultSet1.getString("city"));

            System.out.println("f");

            resultSet1.next();
            receiverName.setText(resultSet1.getString("name"));
            receiverAddress.setText(resultSet1.getString("street") + resultSet1.getString("city"));

            System.out.println("g");

            volume.setText(resultSet.getInt("volume") + "");
            truckAlloted.setText(resultSet.getInt("truckId") + "");

            if (resultSet.getString("dispatchTime").equals("*")) {
                dispatchDate.setText("Not Yet Dispatched");
                dispatchTime.setText("Not Yet Delivered");
            } else {
                dispatchDate.setText(resultSet.getString("dispatchTime").split("T")[0]);
                dispatchTime.setText(resultSet.getString("dispatchTime").split("T")[1]);
            }

            if (resultSet.getString("deliveryTime").equals("*")) {
                deliveryStatus.setText("Not Yet Delivered");
            } else {
                deliveryStatus.setText("Deliverd");
            }

            resultSet.close();
            resultSet1.close();
            statement.close();
            statement1.close();
            connection.close();

        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
    }

}
