package com.ayushtiwari.EmployeeUI;

import com.ayushtiwari.TransportClasses.Customer;
import javafx.beans.property.SimpleStringProperty;

public class CustomerTableItem {
    private SimpleStringProperty name;
    private SimpleStringProperty streetName;
    private SimpleStringProperty cityName;

    public CustomerTableItem(Customer customer) {
        this.name = new SimpleStringProperty(customer.getName());
        this.streetName = new SimpleStringProperty(customer.getAddress().getStreet());
        this.cityName = new SimpleStringProperty(customer.getAddress().getCity());
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
