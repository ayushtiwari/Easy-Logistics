package com.ayushtiwari.TransportCompanyData;

import com.ayushtiwari.TransportClasses.*;

import java.util.ArrayList;
import java.util.List;

public class TransportData {
    private static TransportData instance = new TransportData();
    private Manager manager;
    private List<Employee> employeeList = new ArrayList<>();
    private List<Office> officeList = new ArrayList<>();
    private List<Consignment> consignmentList = new ArrayList<>();
    private List<Truck> truckList = new ArrayList<>();
    private Employee currentEmployee;

    private TransportData() {


    }

    public Employee getCurrentEmployee() {
        return currentEmployee;
    }

    public void setCurrentEmployee(Employee currentEmployee) {
        this.currentEmployee = currentEmployee;
    }

    public Manager getManager() {
        return manager;
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

    public Employee getEmployeeById(int employeeId) {
        for (Employee e : employeeList
        ) {
            if (e.getEmployeeId() == employeeId)
                return e;
        }
        return null;
    }

    public Office getOfficeById(int officeId) {
        for (Office o : officeList) {
            if (o.getOfficeId() == officeId)
                return o;
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


//    public Employee loadEmployee(int employeeId) {
//        //load employee
//    }
//    public Office loadOffice(int officeId) {
//        //load office
//    }
//    public Truck loadTruck(int truckId) {
//        //load truck
//    }



}
