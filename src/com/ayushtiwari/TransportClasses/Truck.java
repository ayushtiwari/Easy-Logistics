package com.ayushtiwari.TransportClasses;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Truck {

    private int truckId;
    private boolean isAvailable;
    private Office currentOffice;
    private int maxCapacity;
    private int currentOccupancy;
    private long[] idleTime;
    private LocalDateTime currentBranchArrivalTime;
    private LocalDateTime currentBranchDepartureTime;
    private List<Consignment> consignmentList;
    private Office nextOffice;

    public Truck(int truckId, Office currentOffice, int maxCapacity) {
        this.truckId = truckId;
        this.currentOffice = currentOffice;
        this.maxCapacity = maxCapacity;
        this.isAvailable = true;
        this.currentOccupancy = 0;
        this.currentBranchArrivalTime = LocalDateTime.now();
        consignmentList = new ArrayList<>();
        idleTime = new long[2];
    }

    public List<Consignment> getConsignmentList() {
        return consignmentList;
    }

    public Office getNextOffice() {
        return nextOffice;
    }

    public void setNextOffice(Office nextOffice) {
        this.nextOffice = nextOffice;
    }


    public int getTruckId() {
        return truckId;
    }

    public void setTruckId(int truckId) {
        this.truckId = truckId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Office getCurrentOffice() {
        return currentOffice;
    }

    public void setCurrentOffice(Office currentOffice) {
        this.currentOffice = currentOffice;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getCurrentOccupancy() {
        return currentOccupancy;
    }

    public void setCurrentOccupancy(int currentOccupancy) {
        this.currentOccupancy = currentOccupancy;
    }

    public long[] getIdleTime() {
        return idleTime;
    }

    public void setIdleTime(long[] idleTime) {
        this.idleTime[0] = idleTime[0];
        this.idleTime[1] = idleTime[1];
    }

    public LocalDateTime getCurrentBranchArrivalTime() {
        return currentBranchArrivalTime;
    }

    public void setCurrentBranchArrivalTime(LocalDateTime currentBranchArrivalTime) {
        this.currentBranchArrivalTime = currentBranchArrivalTime;
    }

    public LocalDateTime getCurrentBranchDepartureTime() {
        return currentBranchDepartureTime;
    }

    public void setCurrentBranchDepartureTime(LocalDateTime currentBranchDepartureTime) {
        this.currentBranchDepartureTime = currentBranchDepartureTime;
    }

    public void loadConsignment(Consignment consignment) {
        this.consignmentList.add(consignment);
        this.setCurrentOccupancy(this.getCurrentOccupancy() + consignment.getVolume());
    }

    public void unloadConsignments() {
        this.consignmentList.clear();
        this.currentOccupancy = 0;
        this.isAvailable = true;
        this.setNextOffice(null);
    }
}
