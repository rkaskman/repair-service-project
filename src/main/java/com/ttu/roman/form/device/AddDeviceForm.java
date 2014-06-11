package com.ttu.roman.form.device;


import com.ttu.roman.model.device.Device;

import javax.validation.Valid;
public class AddDeviceForm {

    @Valid
    private Device device = new Device();
    private Integer deviceTypeId;
    private String clientName;

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Integer getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(Integer deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public String toString() {
        return "AddDeviceForm{" +
                "device=" + device +
                ", deviceTypeId=" + deviceTypeId +
                '}';
    }
}
