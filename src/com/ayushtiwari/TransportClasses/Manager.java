package com.ayushtiwari.TransportClasses;

import java.util.ArrayList;
import java.util.List;

public class Manager {

    private String name;
    private String userName;
    private List<Office> officeList;
    private List<Truck> truckList;
    private List<Employee> employeeList;

    public Manager(String name, String userName) {
        this.name = name;
        this.userName = userName;
        officeList = new ArrayList<>();
    }

    public void addOffice(Office office) {
        officeList.add(office);
    }

    public void addEmployee(Office office, Employee employee) {
        employeeList.add(employee);
        office.getEmployeeList().add(employee);
    }

    public void addTruck(Office office, Truck truck) {
        truckList.add(truck);
        office.getTruckList().add(truck);
    }

    public Truck getTruck(int truckId) {
        Truck truck = null;
        for (Truck t : truckList
        ) {
            if (t.getTruckId() == truckId) {
                truck = t;
                break;
            }
        }

        return truck;
    }


}
