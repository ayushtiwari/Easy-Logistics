package com.ayushtiwari.TransportClasses;

import com.ayushtiwari.TransportCompanyData.TransportData;

public class Manager {

    private String name;
    private String userName;
    private String password;


    public Manager(String name, String userName, String password) {
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addOffice(Office office) {
        TransportData.getInstance().addOffice(office);
    }

    public void addEmployee(Office office, Employee employee) {
        TransportData.getInstance().addEmployee(employee);
        if (!office.getEmployeeList().contains(employee)) {
            office.getEmployeeList().add(0, employee);
        }
    }

    public void addTruck(Office office, Truck truck) {
        TransportData.getInstance().addTruck(truck);
        if (!office.getTruckList().contains(truck)) {
            office.getTruckList().add(0, truck);
        }
    }

    public Truck getTruck(int truckId) {
        Truck truck = null;
        for (Truck t : TransportData.getInstance().getTruckList()
        ) {
            if (t.getTruckId() == truckId) {
                truck = t;
                break;
            }
        }

        return truck;
    }

    public Consignment getConsignment(int consignmentId) {
        Consignment consignment = null;
        for (Consignment c : TransportData.getInstance().getConsignmentList()
        ) {

            if (c.getConsignmentId() == consignmentId) {
                consignment = c;
                break;
            }

        }
        return consignment;
    }

}
