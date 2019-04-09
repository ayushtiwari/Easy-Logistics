package com.ayushtiwari.EmployeeUI;

import com.ayushtiwari.TransportClasses.Consignment;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class IndividualConsignmentDisplayController implements Initializable {

    private Consignment selectedConsignment;
    private int x;

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

    public void initData(int a) {
        System.out.println("AlphaBEtaGammaDeta");
        x = a;
        consignmentId.setText(Integer.toString(x));
    }

}
