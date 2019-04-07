package com.ayushtiwari.TransportClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static boolean isEMpty;
    public static void main(String[] args) {

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
//        employee.enterConsignmentDetails(consignment

//        try {
//            Connection conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Nikhil//Desktop//TransportCompany//database1.db");
//            Statement st = conn.createStatement();
//            st.execute("DELETE FROM manager");
//            //st.execute("INSERT INTO manager VALUES('"+managerName+"','"+managerUserName+"','"+managerEmail+"','"+managerPassword+"')");
//        } catch (SQLException e) {
//            System.out.println("Something went wrong: " + e.getMessage());
//        }
//        // "INSERT INTO `time_entry`(pid,tid,rid,tspend,description) VALUE ('"+pid+"','"+tid+"','"+rid+"',"+tspent+",'"+des+"')"
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Nikhil//Desktop//TransportCompany//database1.db");
            //SqliteHelper s=new SqliteHelper();
            ///Connection conn=s.getConn();
            Statement st = conn.createStatement();
            st.execute("DELETE FROM office");
            st.execute("DELETE FROM employee");
            st.close();
            conn.close();
            //st.execute("INSERT INTO manager VALUES('"+managerName+"','"+managerUserName+"','"+managerEmail+"','"+managerPassword+"')");
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        } catch (NullPointerException f) {
            System.out.println("Something went wrong: " + f.getMessage());
        }



    }
}
