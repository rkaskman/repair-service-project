package com.ttu.roman.form.deviceservice;


public class DeviceServiceActionFormEdit {

    private Integer serviceActionId;
    private Integer serviceDeviceId;
    private String actionDescription;
    private Integer serviceType;
    private String serviceAmount;
    private String price;
    private String totalPrice;
    private Integer serviceActionStatusType;
    private Integer deviceInService;

    public Integer getDeviceInService() {
        return deviceInService;
    }

    public void setDeviceInService(Integer deviceInService) {
        this.deviceInService = deviceInService;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getServiceActionStatusType() {
        return serviceActionStatusType;
    }

    public void setServiceActionStatusType(Integer serviceActionStatusType) {
        this.serviceActionStatusType = serviceActionStatusType;
    }

    public Integer getServiceActionId() {
        return serviceActionId;
    }

    public void setServiceActionId(Integer serviceActionId) {
        this.serviceActionId = serviceActionId;
    }

    public String getActionDescription() {
        return actionDescription;
    }

    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
    }

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceAmount() {
        return serviceAmount;
    }

    public void setServiceAmount(String serviceAmount) {
        this.serviceAmount = serviceAmount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getServiceDeviceId() {
        return serviceDeviceId;
    }

    public void setServiceDeviceId(Integer serviceDeviceId) {
        this.serviceDeviceId = serviceDeviceId;
    }
}
