package com.ttu.roman.form.serviceorder;


import java.util.List;

public class AddServiceOrderForm {

    private List<Integer> devices;
    private Integer serviceRequestId;

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
