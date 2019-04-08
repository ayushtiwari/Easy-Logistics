package com.ayushtiwari.TransportClasses;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Employee {
    private int employeeId;
    private String name;
    private Office office;
    private String userName;
    private String passWord;

    public Employee(int employeeId, String name, Office office, String userName, String passWord) {
        this.employeeId = employeeId;
        this.name = name;
        this.office = office;
        this.userName = userName;
        this.passWord = passWord;
        office.getEmployeeList().add(this);
    }

//    public void setOffice(Office office) {
//        this.office = office;
//    }


    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public Office getOffice() {
        return office;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void dispatchTruck(Truck truck) {
        if (office.getTruckList().contains(truck)) {
            truck.setCurrentBranchDepartureTime(LocalDateTime.now());
            truck.getIdleTime()[0] = ChronoUnit.HOURS.between(truck.getCurrentBranchArrivalTime(), truck.getCurrentBranchDepartureTime());
            truck.getIdleTime()[1] = ChronoUnit.MINUTES.between(truck.getCurrentBranchArrivalTime(), truck.getCurrentBranchDepartureTime());
            office.getTruckList().remove(truck);
        }

        for (Consignment c : truck.getConsignmentList()) {
            c.setDepartureTime(LocalDateTime.now());
            c.setDispatched(true);
        }
    }

    public void receiveTruck(Truck truck) {
        if (truck.getNextOffice() == this.office) {
            truck.setAvailable(true);
            truck.setCurrentOffice(office);
            truck.setCurrentBranchArrivalTime(LocalDateTime.now());
            for (Consignment c : truck.getConsignmentList()) {
                c.setDelivered(true);
                c.setDeliveredTime(LocalDateTime.now());
            }
            truck.unloadConsignments();
            office.getTruckList().add(0, truck);
        } else {
            System.out.println("Cannot receive Truck in this office");
        }
    }

    public void enterConsignmentDetails(Consignment consignment) {
        consignment.setArrivalTime(LocalDateTime.now());
        if (office.assignTruck(consignment)) {
            System.out.println("Successful");
        } else {
            System.out.println("Reject Consignment");
        }
    }

}
