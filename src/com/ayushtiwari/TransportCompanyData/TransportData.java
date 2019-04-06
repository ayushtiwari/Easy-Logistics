package com.ayushtiwari.TransportCompanyData;

import com.ayushtiwari.TransportClasses.Consignment;
import com.ayushtiwari.TransportClasses.Employee;
import com.ayushtiwari.TransportClasses.Office;
import com.ayushtiwari.TransportClasses.Truck;

import java.util.ArrayList;
import java.util.List;

public class TransportData {
    private static TransportData instance = new TransportData();

    private List<Employee> employeeList = new ArrayList<>();
    private List<Office> officeList = new ArrayList<>();
    private List<Consignment> consignmentList = new ArrayList<>();
    private List<Truck> truckList = new ArrayList<>();

    private TransportData() {

    }

    public static TransportData getInstance() {
        return instance;
    }


    public List<Truck> getTruckList() {
        return truckList;
    }

    public Truck getTruckById(int truckId) {

        for (Truck t : truckList
        ) {
            if (t.getTruckId() == truckId)
                return t;
        }
        return null;
    }

    public void addTruck(Truck truck) {
        truckList.add(truck);
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public List<Office> getOfficeList() {
        return officeList;
    }

    public void addOffice(Office office) {
        officeList.add(office);
    }

    public List<Consignment> getConsignmentList() {
        return consignmentList;
    }

    public void addConsignment(Consignment consignment) {
        consignmentList.add(consignment);
    }
}
