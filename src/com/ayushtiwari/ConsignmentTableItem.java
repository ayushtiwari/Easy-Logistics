package com.ayushtiwari;

import com.ayushtiwari.TransportClasses.Consignment;
import javafx.beans.property.SimpleStringProperty;

public class ConsignmentTableItem {

    //    private int consignmentId;
//    private int volume;
//    private Customer sender;
//    private Customer receiver;
//    private boolean isDelivered;
//    private boolean isDispatched;
//    private LocalDateTime arrivalTime;
//    private LocalDateTime departureTime;
//    private LocalDateTime deliveredTime;
//    private Truck truck;
//    private Office sendingOffice;
//    private Office receivingOffice;
    private SimpleStringProperty id;
    private SimpleStringProperty sendersName;
    private SimpleStringProperty sendingOfficeId;
    private SimpleStringProperty receivingOfficeId;
    private SimpleStringProperty isDelivered;
    private SimpleStringProperty isDispatched;


    public ConsignmentTableItem(Consignment consignment) {
        this.id = new SimpleStringProperty(Integer.toString(consignment.getConsignmentId()));
        this.sendersName = new SimpleStringProperty(consignment.getSender().getName());
        this.sendingOfficeId = new SimpleStringProperty(Integer.toString(consignment.getSendingOffice().getOfficeId()));
        this.receivingOfficeId = new SimpleStringProperty(Integer.toString(consignment.getReceivingOffice().getOfficeId()));
        this.isDelivered = new SimpleStringProperty(Boolean.toString(consignment.isDelivered()));
        this.isDispatched = new SimpleStringProperty(Boolean.toString(consignment.isDispatched()));

    }

    public ConsignmentTableItem(String id, String sendersName, String sendingOfficeId, String receivingOfficeId, String isDelivered, String isDispatched) {
        this.id = new SimpleStringProperty(id);
        this.sendersName = new SimpleStringProperty(sendersName);
        this.sendingOfficeId = new SimpleStringProperty(sendingOfficeId);
        this.receivingOfficeId = new SimpleStringProperty(receivingOfficeId);
        this.isDelivered = new SimpleStringProperty(isDelivered);
        this.isDispatched = new SimpleStringProperty(isDispatched);
    }

    public String getIsDispatched() {
        return isDispatched.get();
    }

    public void setIsDispatched(String isDispatched) {
        this.isDispatched.set(isDispatched);
    }

    public SimpleStringProperty isDispatchedProperty() {
        return isDispatched;
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public String getSendersName() {
        return sendersName.get();
    }

    public void setSendersName(String sendersName) {
        this.sendersName.set(sendersName);
    }

    public SimpleStringProperty sendersNameProperty() {
        return sendersName;
    }

    public String getSendingOfficeId() {
        return sendingOfficeId.get();
    }

    public void setSendingOfficeId(String sendingOfficeId) {
        this.sendingOfficeId.set(sendingOfficeId);
    }

    public SimpleStringProperty sendingOfficeIdProperty() {
        return sendingOfficeId;
    }

    public String getReceivingOfficeId() {
        return receivingOfficeId.get();
    }

    public void setReceivingOfficeId(String receivingOfficeId) {
        this.receivingOfficeId.set(receivingOfficeId);
    }

    public SimpleStringProperty receivingOfficeIdProperty() {
        return receivingOfficeId;
    }

    public String getIsDelivered() {
        return isDelivered.get();
    }

    public void setIsDelivered(String isDelivered) {
        this.isDelivered.set(isDelivered);
    }

    public SimpleStringProperty isDeliveredProperty() {
        return isDelivered;
    }
}
