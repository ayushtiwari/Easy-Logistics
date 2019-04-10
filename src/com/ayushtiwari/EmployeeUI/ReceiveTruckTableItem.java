package com.ayushtiwari.EmployeeUI;

import javafx.beans.property.SimpleStringProperty;

public class ReceiveTruckTableItem {

    private SimpleStringProperty truckId;
    private SimpleStringProperty sendingBranch;
    private SimpleStringProperty expectedDate;
    private SimpleStringProperty volumeFilled;
    private SimpleStringProperty driverDetails;

    public ReceiveTruckTableItem(String truckId, String sendingBranch, String occupancy) {
        this.truckId = new SimpleStringProperty(truckId);
        this.sendingBranch = new SimpleStringProperty(sendingBranch);
        this.volumeFilled = new SimpleStringProperty(occupancy);
    }

    public String getTruckId() {
        return truckId.get();
    }

    public void setTruckId(String truckId) {
        this.truckId.set(truckId);
    }

    public SimpleStringProperty truckIdProperty() {
        return truckId;
    }

    public String getSendingBranch() {
        return sendingBranch.get();
    }

    public void setSendingBranch(String sendingBranch) {
        this.sendingBranch.set(sendingBranch);
    }

    public SimpleStringProperty sendingBranchProperty() {
        return sendingBranch;
    }

    public String getExpectedDate() {
        return expectedDate.get();
    }

    public void setExpectedDate(String expectedDate) {
        this.expectedDate.set(expectedDate);
    }

    public SimpleStringProperty expectedDateProperty() {
        return expectedDate;
    }

    public String getVolumeFilled() {
        return volumeFilled.get();
    }

    public void setVolumeFilled(String volumeFilled) {
        this.volumeFilled.set(volumeFilled);
    }

    public SimpleStringProperty volumeFilledProperty() {
        return volumeFilled;
    }

    public String getDriverDetails() {
        return driverDetails.get();
    }

    public void setDriverDetails(String driverDetails) {
        this.driverDetails.set(driverDetails);
    }

    public SimpleStringProperty driverDetailsProperty() {
        return driverDetails;
    }
}
