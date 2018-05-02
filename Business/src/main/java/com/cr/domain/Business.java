package com.cr.domain;

public class Business {
    private String id;

    private String busLoginname;

    private String busPassword;

    private String busName;

    private String busImg;

    private String busLicense;

    private String busAddress;

    private String isCheck;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBusLoginname() {
        return busLoginname;
    }

    public void setBusLoginname(String busLoginname) {
        this.busLoginname = busLoginname == null ? null : busLoginname.trim();
    }

    public String getBusPassword() {
        return busPassword;
    }

    public void setBusPassword(String busPassword) {
        this.busPassword = busPassword == null ? null : busPassword.trim();
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName == null ? null : busName.trim();
    }

    public String getBusImg() {
        return busImg;
    }

    public void setBusImg(String busImg) {
        this.busImg = busImg == null ? null : busImg.trim();
    }

    public String getBusLicense() {
        return busLicense;
    }

    public void setBusLicense(String busLicense) {
        this.busLicense = busLicense == null ? null : busLicense.trim();
    }

    public String getBusAddress() {
        return busAddress;
    }

    public void setBusAddress(String busAddress) {
        this.busAddress = busAddress == null ? null : busAddress.trim();
    }

    public String getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(String isCheck) {
        this.isCheck = isCheck == null ? null : isCheck.trim();
    }
}