package com.ayushtiwari;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class ConsignmentHistoryController {

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


}
