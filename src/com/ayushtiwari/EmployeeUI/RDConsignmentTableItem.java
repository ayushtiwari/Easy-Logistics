package com.ayushtiwari.EmployeeUI;

import javafx.beans.property.SimpleStringProperty;

public class RDConsignmentTableItem {
    private SimpleStringProperty consignmentId;
    private SimpleStringProperty volume;

    public RDConsignmentTableItem(String consignmentId, String consignmentVolume) {
        this.consignmentId = new SimpleStringProperty(consignmentId);
        this.volume = new SimpleStringProperty(consignmentVolume);
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
