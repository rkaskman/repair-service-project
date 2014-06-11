package com.ttu.roman.form.deviceservice;

/**
 * Created by roman on 6/11/14.
 */
public class ServicePartForm {

    private Integer servicePartId;
    private Integer deviceId;
    private Integer deviceInService;
    private String serialNo;
    private String partName;
    private String partPrice;
    private String partCount;

    public Integer getServicePartId() {
        return servicePartId;
    }

    public void setServicePartId(Integer servicePartId) {
        this.servicePartId = servicePartId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getDeviceInService() {
        return deviceInService;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public void setDeviceInService(Integer deviceInService) {
        this.deviceInService = deviceInService;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getPartPrice() {
        return partPrice;
    }

    public void setPartPrice(String partPrice) {
        this.partPrice = partPrice;
    }

    public String getPartCount() {
        return partCount;
    }

    public void setPartCount(String partCount) {
        this.partCount = partCount;
    }
}
