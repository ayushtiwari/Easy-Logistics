package com.ayushtiwari.TransportClasses;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Consignment {
    private int consignmentId;
    private int volume;
    private Customer sender;
    private Customer receiver;
    private boolean isDelivered;
    private boolean isDispatched;
    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;
    private LocalDateTime deliverdTime;
    private Truck truck;
    private Office sendingOffice;
    private Office receivingOffice;

    public Consignment(int consignmentId, int volume, Customer sender, Customer receiver, Office sendingOffice, Office receivingOffice) {
        this.consignmentId = consignmentId;
        this.volume = volume;
        this.sender = sender;
        this.receiver = receiver;
        this.isDelivered = false;
        this.sendingOffice = sendingOffice;
        this.receivingOffice = receivingOffice;
        this.arrivalTime = LocalDateTime.now();
        this.isDispatched = false;
    }

    public LocalDateTime getDeliverdTime() {
        return deliverdTime;
    }

    public void setDeliverdTime(LocalDateTime deliverdTime) {
        this.deliverdTime = deliverdTime;
    }

    public Office getSendingOffice() {
        return sendingOffice;
    }


    public Office getReceivingOffice() {
        return receivingOffice;
    }


    public int getConsignmentId() {
        return consignmentId;
    }


    public long[] getWaitingTime() {
        long[] waitingTime = new long[2];
        if (this.isDelivered()) {
            waitingTime[0] = ChronoUnit.HOURS.between(this.arrivalTime, this.departureTime);
            waitingTime[1] = ChronoUnit.MINUTES.between(this.arrivalTime, this.departureTime);
            return waitingTime;
        } else return null;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Customer getSender() {
        return sender;
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }

    public Customer getReceiver() {
        return receiver;
    }

    public void setReceiver(Customer receiver) {
        this.receiver = receiver;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }


    public boolean isDispatched() {
        return isDispatched;
    }

    public void setDispatched(boolean dispatched) {
        isDispatched = dispatched;
    }
}
