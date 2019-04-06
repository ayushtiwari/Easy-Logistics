package com.ayushtiwari.TransportClasses;

public class Main {
    public static void main(String[] args) {

        Manager manager = new Manager("Sanjay Gupta", "sanjaygupta");

        Office office = new Office(new Address("AlphaBeta", "JingleBell"));

        Employee employee = new Employee(1234, "Supreme");

        manager.addOffice(office);
        manager.addEmployee(office, employee);

        manager.addTruck(office, new Truck(123, office, 240));


    }
}
