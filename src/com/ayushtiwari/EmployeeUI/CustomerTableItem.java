package com.ayushtiwari.EmployeeUI;

import javafx.beans.property.SimpleStringProperty;

public class CustomerTableItem {
    private SimpleStringProperty name;
    private SimpleStringProperty streetName;
    private SimpleStringProperty cityName;
    private SimpleStringProperty consignmentId;

    public CustomerTableItem(String name, String street, String city, String consignmentId) {
        this.name = new SimpleStringProperty(name);
        this.streetName = new SimpleStringProperty(street);
        this.cityName = new SimpleStringProperty(city);
        this.consignmentId = new SimpleStringProperty(consignmentId);
    }

    public String getConsignmentId() {
        return consignmentId.get();
    }

    public void setConsignmentId(String consignmentId) {
        this.consignmentId.set(consignmentId);
    }

    public SimpleStringProperty consignmentIdProperty() {
        return consignmentId;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public SimpleStringProperty nameProperty() {
        return name;
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
}
