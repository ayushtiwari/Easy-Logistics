package com.ayushtiwari.TransportClasses;

import java.util.ArrayList;
import java.util.List;

public class Office {

    private Address address;
    private int officeId;
    private List<Employee> employeeList;
    private List<Truck> truckList;
    private List<Consignment> consignmentList;

    public Office(int officeId, Address address) {
        this.address = address;
        truckList = new ArrayList<>();
        consignmentList = new ArrayList<>();
        employeeList = new ArrayList<>();
        this.officeId = officeId;

    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public List<Consignment> getConsignmentList() {
        return consignmentList;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Truck> getTruckList() {
        return truckList;
    }

    public boolean assignTruck(Consignment consignment) {
        this.getConsignmentList().add(consignment);
        int i = truckList.size();
        i = i - 1;
        boolean flag = false;
        if (truckList.size() > 0) {
            while (i >= 0) {
                Truck trucki = truckList.get(i);
                if (trucki.getCurrentOccupancy() == 0 && trucki.getMaxCapacity() >= consignment.getVolume()) {
                    trucki.setNextOffice(consignment.getReceivingOffice());
                    trucki.loadConsignment(consignment);
                    consignment.setTruck(trucki);
                    flag = true;
                    break;
                } else if (trucki.getCurrentOccupancy() != 0 && trucki.getCurrentOccupancy() + consignment.getVolume() <= trucki.getMaxCapacity() && trucki.getNextOffice() == consignment.getReceivingOffice()) {
                    trucki.loadConsignment(consignment);
                    consignment.setTruck(trucki);
                    flag = true;
                    break;
                }
                i--;
            }
        }
        return flag;
    }
}
