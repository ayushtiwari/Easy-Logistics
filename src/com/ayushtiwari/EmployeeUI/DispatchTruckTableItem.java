package com.ayushtiwari.EmployeeUI;

import javafx.beans.property.SimpleStringProperty;

public class DispatchTruckTableItem {

    private SimpleStringProperty truckId;
    private SimpleStringProperty destinationBranch;
    private SimpleStringProperty capacity;
    private SimpleStringProperty occupancy;
    private SimpleStringProperty driverId;

    public DispatchTruckTableItem(String truckId, String destinationBranch, String Capacity, String occupancy) {
        this.truckId = new SimpleStringProperty(truckId);
        this.destinationBranch = new SimpleStringProperty(destinationBranch);
        this.capacity = new SimpleStringProperty(Capacity);
        this.occupancy = new SimpleStringProperty(occupancy);
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

    public String getDestinationBranch() {
        return destinationBranch.get();
    }

    public void setDestinationBranch(String destinationBranch) {
        this.destinationBranch.set(destinationBranch);
    }

    public SimpleStringProperty destinationBranchProperty() {
        return destinationBranch;
    }

    public String getCapacity() {
        return capacity.get();
    }

    public void setCapacity(String capacity) {
        this.capacity.set(capacity);
    }

    public SimpleStringProperty capacityProperty() {
        return capacity;
    }

    public String getOccupancy() {
        return occupancy.get();
    }

    public void setOccupancy(String occupancy) {
        this.occupancy.set(occupancy);
    }

    public SimpleStringProperty occupancyProperty() {
        return occupancy;
    }

    public String getDriverId() {
        return driverId.get();
    }

    public void setDriverId(String driverId) {
        this.driverId.set(driverId);
    }

    public SimpleStringProperty driverIdProperty() {
        return driverId;
    }
}
