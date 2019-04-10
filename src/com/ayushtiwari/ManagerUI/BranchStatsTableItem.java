package com.ayushtiwari.ManagerUI;

import javafx.beans.property.SimpleStringProperty;

public class BranchStatsTableItem {
    private SimpleStringProperty branchId;
    private SimpleStringProperty streetName;
    private SimpleStringProperty cityName;
    private SimpleStringProperty noOfEmployees;

    public BranchStatsTableItem(String branchId, String streetName, String cityName, String noOfEmployees) {
        this.branchId = new SimpleStringProperty(branchId);
        this.streetName = new SimpleStringProperty(streetName);
        this.cityName = new SimpleStringProperty(cityName);
        this.noOfEmployees = new SimpleStringProperty(noOfEmployees);

    }

    public String getBranchId() {
        return branchId.get();
    }

    public void setBranchId(String branchId) {
        this.branchId.set(branchId);
    }

    public SimpleStringProperty branchIdProperty() {
        return branchId;
    }

    public String getStreetName() {
        return streetName.get();
    }

    public void setStreetName(String streetName) {
        this.streetName.set(streetName);
    }

    public SimpleStringProperty streetNameProperty() {
        return streetName;
    }

    public String getCityName() {
        return cityName.get();
    }

    public void setCityName(String cityName) {
        this.cityName.set(cityName);
    }

    public SimpleStringProperty cityNameProperty() {
        return cityName;
    }

    public String getNoOfEmployees() {
        return noOfEmployees.get();
    }

    public void setNoOfEmployees(String noOfEmployees) {
        this.noOfEmployees.set(noOfEmployees);
    }

    public SimpleStringProperty noOfEmployeesProperty() {
        return noOfEmployees;
    }
}
