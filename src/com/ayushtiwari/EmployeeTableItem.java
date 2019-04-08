package com.ayushtiwari;

import com.ayushtiwari.TransportClasses.Employee;
import javafx.beans.property.SimpleStringProperty;

public class EmployeeTableItem {
    private SimpleStringProperty name;
    private SimpleStringProperty branch;
    private SimpleStringProperty employeeId;
    private SimpleStringProperty userName;

    public EmployeeTableItem(Employee employee) {
        this.name = new SimpleStringProperty(employee.getName());
        this.branch = new SimpleStringProperty(Integer.toString(employee.getOffice().getOfficeId()));
        this.employeeId = new SimpleStringProperty(Integer.toString(employee.getEmployeeId()));
        this.userName = new SimpleStringProperty(employee.getUserName());
    }

    public String getUserName() {
        return userName.get();
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public SimpleStringProperty userNameProperty() {
        return userName;
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

    public String getBranch() {
        return branch.get();
    }

    public void setBranch(String branch) {
        this.branch.set(branch);
    }

    public SimpleStringProperty branchProperty() {
        return branch;
    }

    public String getEmployeeId() {
        return employeeId.get();
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId.set(employeeId);
    }

    public SimpleStringProperty employeeIdProperty() {
        return employeeId;
    }
}
