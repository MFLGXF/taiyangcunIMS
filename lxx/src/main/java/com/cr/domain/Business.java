package com.cr.domain;

public class Business {
    private String id;

    private String y;

    private String x;

    private String address;

    private String companyName;

    private String companyLeader;

    private Integer scale;

    private String revenue;

    private String taxes;

    private String logo;

    private String industry;

    private Integer isLocal;

    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y == null ? null : y.trim();
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x == null ? null : x.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyLeader() {
        return companyLeader;
    }

    public void setCompanyLeader(String companyLeader) {
        this.companyLeader = companyLeader == null ? null : companyLeader.trim();
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue == null ? null : revenue.trim();
    }

    public String getTaxes() {
        return taxes;
    }

    public void setTaxes(String taxes) {
        this.taxes = taxes == null ? null : taxes.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public Integer getIsLocal() {
        return isLocal;
    }

    public void setIsLocal(Integer isLocal) {
        this.isLocal = isLocal;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }
}