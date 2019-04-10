package com.ayushtiwari.ManagerUI;

import javafx.beans.property.SimpleStringProperty;

public class TruckTableItem {

    private SimpleStringProperty truckId;
    private SimpleStringProperty currentBranch;
    private SimpleStringProperty averageTruckIdleTime;
    private SimpleStringProperty occupancy;
    private SimpleStringProperty capacity;

    public TruckTableItem(int truckId, long idleHours, long idleMinutes, int currentBranchId, String currentBranchCityName, int occupancy, int capacity) {
        this.truckId = new SimpleStringProperty(Integer.toString(truckId));

        this.averageTruckIdleTime = new SimpleStringProperty(idleHours + "h " + idleMinutes + "m");
        this.capacity = new SimpleStringProperty(Integer.toString(capacity));
        this.occupancy = new SimpleStringProperty(Integer.toString(occupancy));
        this.currentBranch = new SimpleStringProperty(currentBranchId + " - " + currentBranchCityName);
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

    public String getCurrentBranch() {
        return currentBranch.get();
    }

    public void setCurrentBranch(String currentBranch) {
        this.currentBranch.set(currentBranch);
    }

    public SimpleStringProperty currentBranchProperty() {
        return currentBranch;
    }

    public String getAverageTruckIdleTime() {
        return averageTruckIdleTime.get();
    }

    public void setAverageTruckIdleTime(String averageTruckIdleTime) {
        this.averageTruckIdleTime.set(averageTruckIdleTime);
    }

    public SimpleStringProperty averageTruckIdleTimeProperty() {
        return averageTruckIdleTime;
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

    public String getCapacity() {
        return capacity.get();
    }

    public void setCapacity(String capacity) {
        this.capacity.set(capacity);
    }

    public SimpleStringProperty capacityProperty() {
        return capacity;
    }
}
