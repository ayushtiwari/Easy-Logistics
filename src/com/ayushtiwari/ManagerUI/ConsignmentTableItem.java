package com.ayushtiwari.ManagerUI;


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
    private SimpleStringProperty arrivalTime;
    private SimpleStringProperty dispatchTime;


//    public ConsignmentTableItem(Consignment consignment) {
//        this.id = new SimpleStringProperty(Integer.toString(consignment.getConsignmentId()));
//        this.sendersName = new SimpleStringProperty(consignment.getSender().getName());
//        this.sendingOfficeId = new SimpleStringProperty(Integer.toString(consignment.getSendingOffice().getOfficeId()));
//        this.receivingOfficeId = new SimpleStringProperty(Integer.toString(consignment.getReceivingOffice().getOfficeId()));
//        this.isDelivered = new SimpleStringProperty(Boolean.toString(consignment.isDelivered()));
//        this.isDispatched = new SimpleStringProperty(Boolean.toString(consignment.isDispatched()));
//
//    }

    public ConsignmentTableItem(String id, String sendersName, String sendingOfficeId, String receivingOfficeId, String arrivalTime, String dispatchTime) {
        this.id = new SimpleStringProperty(id);
        this.sendersName = new SimpleStringProperty(sendersName);
        this.sendingOfficeId = new SimpleStringProperty(sendingOfficeId);
        this.receivingOfficeId = new SimpleStringProperty(receivingOfficeId);
        this.arrivalTime = new SimpleStringProperty(arrivalTime);
        this.dispatchTime = new SimpleStringProperty(dispatchTime);
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

    public String getArrivalTime() {
        return arrivalTime.get();
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime.set(arrivalTime);
    }

    public SimpleStringProperty arrivalTimeProperty() {
        return arrivalTime;
    }

    public String getDispatchTime() {
        return dispatchTime.get();
    }

    public void setDispatchTime(String dispatchTime) {
        this.dispatchTime.set(dispatchTime);
    }

    public SimpleStringProperty dispatchTimeProperty() {
        return dispatchTime;
    }
}
