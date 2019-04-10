package com.ayushtiwari.TransportCompanyData;

public class TransportData {
    private static TransportData instance = new TransportData();

    private int employeeId;
    private int officeId;
    private String[] consignmentIdList;
    private String[] truckId;

    private TransportData() {


    }

    public static TransportData getInstance() {
        return instance;
    }

    public static void setInstance(TransportData instance) {
        TransportData.instance = instance;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public String[] getConsignmentIdList() {
        return consignmentIdList;
    }

    public void setConsignmentIdList(String[] consignmentIdList) {
        this.consignmentIdList = consignmentIdList;
    }

    public String[] getTruckId() {
        return truckId;
    }

    public void setTruckId(String[] truckId) {
        this.truckId = truckId;
    }

    //    public void addTruck(Truck truck) {
//        truckList.add(truck);
//    }
//
//    public List<Employee> getEmployeeList() {
//        return employeeList;
//    }
//
//    public void addEmployee(Employee employee) {
//        employeeList.add(employee);
//    }
//
//    public List<Office> getOfficeList() {
//        return officeList;
//    }
//
//    public void addOffice(Office office) {
//        officeList.add(office);
//    }
//
//    public List<Consignment> getConsignmentList() {
//        return consignmentList;
//    }
//
//    public void addConsignment(Consignment consignment) {
//        consignmentList.add(consignment);
//    }
//
//
////    public Employee loadEmployee(int employeeId) {
////        //load employee
////    }
////    public Office loadOffice(int officeId) {
////        //load office
////    }
////    public Truck loadTruck(int truckId) {
////        //load truck
////    }
//


}
