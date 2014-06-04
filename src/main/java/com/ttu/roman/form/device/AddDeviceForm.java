package com.ttu.roman.form.device;


import com.ttu.roman.model.device.Device;

public class AddDeviceForm {
    private Device device = new Device();
    private Integer deviceTypeId;

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

    @Override
    public String toString() {
        return "AddDeviceForm{" +
                "device=" + device +
                ", deviceTypeId=" + deviceTypeId +
                '}';
    }
}
