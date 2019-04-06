package com.ayushtiwari.TransportClasses;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Employee {
    private int employeeId;
    private String name;
    private Office office;

    public Employee(int employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
    }

    public void setOffice(Office office) {
        this.office = office;
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
        truck.setCurrentBranchDepartureTime(LocalDateTime.now());
        truck.getIdleTime()[0] = ChronoUnit.HOURS.between(truck.getCurrentBranchArrivalTime(), truck.getCurrentBranchDepartureTime());
        truck.getIdleTime()[1] = ChronoUnit.MINUTES.between(truck.getCurrentBranchArrivalTime(), truck.getCurrentBranchDepartureTime());
        office.getTruckList().remove(truck);

        for (Consignment c : truck.getConsignmentList()) {
            c.setDepartureTime(LocalDateTime.now());
            c.setDelivered(true);
        }

    }

    public void receiveTruck(Truck truck) {
        truck.setAvailable(true);
        truck.setCurrentOffice(office);
        truck.setCurrentBranchArrivalTime(LocalDateTime.now());
        truck.unloadConsignments();
        office.getTruckList().add(0, truck);

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
