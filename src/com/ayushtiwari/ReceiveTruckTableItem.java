package com.ayushtiwari;

import com.ayushtiwari.TransportClasses.Truck;
import javafx.beans.property.SimpleStringProperty;

public class ReceiveTruckTableItem {

    private SimpleStringProperty truckId;
    private SimpleStringProperty sendingBranch;
    private SimpleStringProperty expectedDate;
    private SimpleStringProperty volumeFilled;
    private SimpleStringProperty driverDetails;

    public ReceiveTruckTableItem(Truck truck) {
        this.truckId = new SimpleStringProperty(Integer.toString(truck.getTruckId()));
        this.sendingBranch = new SimpleStringProperty(Integer.toString(truck.getCurrentOffice().getOfficeId()));
        this.volumeFilled = new SimpleStringProperty(Integer.toString(truck.getCurrentOccupancy()));
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
