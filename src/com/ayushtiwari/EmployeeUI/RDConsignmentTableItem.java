package com.ayushtiwari.EmployeeUI;

import com.ayushtiwari.TransportClasses.Consignment;
import javafx.beans.property.SimpleStringProperty;

public class RDConsignmentTableItem {
    private SimpleStringProperty consignmentId;
    private SimpleStringProperty volume;

    public RDConsignmentTableItem(Consignment consignment) {
        this.consignmentId = new SimpleStringProperty(Integer.toString(consignment.getConsignmentId()));
        this.volume = new SimpleStringProperty(Integer.toString(consignment.getVolume()));
    }

    public String getConsignmentId() {
        return consignmentId.get();
    }

    public void setConsignmentId(String consignmentId) {
        this.consignmentId.set(consignmentId);
    }

    public SimpleStringProperty consignmentIdProperty() {
        return consignmentId;
    }

    public String getVolume() {
        return volume.get();
    }

    public void setVolume(String volume) {
        this.volume.set(volume);
    }

    public SimpleStringProperty volumeProperty() {
        return volume;
    }
}
