package com.ayushtiwari.TransportClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Nikhil//Desktop//TransportCompany//database1.db");
            Statement st = conn.createStatement();
            st.execute("CREATE TABLE IF NOT EXISTS employee(employee_id INTEGER, employee_name TEXT, branch_id INTEGER , employee_username TEXT,employee_password TEXT)");
            st.execute("CREATE TABLE IF NOT EXISTS office(office_id INTEGER ,employee_list TEXT, address_street TEXT, address_city TEXT, truck_list TEXT, consignment_list TEXT)");
            st.execute("CREATE TABLE IF NOT EXISTS manager(name TEXT, email TEXT, username TEXT,password TEXT)");


        } catch (SQLException e) {
            System.out.println(("Something went wrong" + e.getMessage()));
        }
//        Manager manager = new Manager("Sanjay Gupta", "sanjaygupta");
//
//        Office office = new Office(new Address("AlphaBeta", "JingleBell"));
//        Office office1 = new Office(new Address("Alphonse", "Jilphonso"));
//        Employee employee = new Employee(1234, "Supreme", office);
//
//        Customer customer1 = new Customer("Ayush", new Address("Alpha", "beta"));
//        Customer customer2 = new Customer("gamma", new Address("delta", "epsilon"));
//
//        manager.addOffice(office);
//        manager.addEmployee(office, employee);
//        manager.addTruck(office, new Truck(123, office, 200));
//
//        Employee employee1 = new Employee(1111, "Sumi", office1);
//        manager.addEmployee(office1, employee);
//        System.out.println(employee.getOffice().getTruckList());
//
//        Consignment consignment = new Consignment(1, 120, customer1, customer2, office, office1);
//
//        employee.enterConsignmentDetails(consignment);
//
//        employee.dispatchTruck(TransportData.getInstance().getTruckById(123));
//
//        employee1.receiveTruck(TransportData.getInstance().getTruckById(123));
//
//        employee.enterConsignmentDetails(consignment);

    }
}
