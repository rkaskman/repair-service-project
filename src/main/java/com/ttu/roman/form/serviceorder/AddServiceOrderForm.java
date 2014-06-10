package com.ttu.roman.form.serviceorder;


import java.util.List;

public class AddServiceOrderForm {

    private List<Integer> devices;
    private Integer serviceRequestId;
    private Integer serviceOrderId;
    private String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getServiceOrderId() {
        return serviceOrderId;
    }

    public void setServiceOrderId(Integer serviceOrderId) {
        this.serviceOrderId = serviceOrderId;
    }

    public Integer getServiceRequestId() {
        return serviceRequestId;
    }

    public void setServiceRequestId(Integer serviceRequestId) {
        this.serviceRequestId = serviceRequestId;
    }

    public List<Integer> getDevices() {
        return devices;
    }

    public void setDevices(List<Integer> devices) {
        this.devices = devices;
    }
}
