package com.example.vcanteenvendor;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Vendor {

    @SerializedName("vendor_id")
    private int vendorId;

    @SerializedName("adminPermission")
    private String adminPermission;

    @SerializedName("vendorNo")
    private int vendorNo;

    @SerializedName("vendorName")
    private String vendorName;

    @SerializedName("vendorStatus")
    private String vendorStatus;

    @SerializedName("vendorImage")
    private String vendorImage;

    @SerializedName("vendorPassword")
    private String vendorPassword;

    @SerializedName("vendorAccountType")
    private String vendorAccountType;

    @SerializedName("vendorEmail")
    private String vendorEmail;

    @SerializedName("vendorPaymentMethod")
    private List<ServiceProvider> vendorPaymentMethod;

    public Vendor(int vendorId, String adminPermission, int vendorNo, String vendorName, String vendorStatus, String vendorImage, String vendorPassword, String vendorAccountType, String vendorEmail, List<ServiceProvider> vendorPaymentMethod) {
        this.vendorId = vendorId;
        this.adminPermission = adminPermission;
        this.vendorNo = vendorNo;
        this.vendorName = vendorName;
        this.vendorStatus = vendorStatus;
        this.vendorImage = vendorImage;
        this.vendorPassword = vendorPassword;
        this.vendorAccountType = vendorAccountType;
        this.vendorEmail = vendorEmail;
        this.vendorPaymentMethod = vendorPaymentMethod;
    }

    public Vendor() {
    }

    public Boolean findServiceProviderFromList(List<ServiceProvider> vendorPaymentMethod, String account) {

        for (ServiceProvider serviceProvider : vendorPaymentMethod) {
            if (serviceProvider.getAccount().equals(account)) {
                return true;
            }
        }
        return false;
    }



    public List<ServiceProvider> getVendorPaymentMethod() {
        return vendorPaymentMethod;
    }

    public void setVendorPaymentMethod(List<ServiceProvider> vendorPaymentMethod) {
        this.vendorPaymentMethod = vendorPaymentMethod;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public String getAdminPermission() {
        return adminPermission;
    }

    public void setAdminPermission(String adminPermission) {
        this.adminPermission = adminPermission;
    }

    public int getVendorNo() {
        return vendorNo;
    }

    public void setVendorNo(int vendorNo) {
        this.vendorNo = vendorNo;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorStatus() {
        return vendorStatus;
    }

    public void setVendorStatus(String vendorStatus) {
        this.vendorStatus = vendorStatus;
    }

    public String getVendorImage() {
        return vendorImage;
    }

    public void setVendorImage(String vendorImage) {
        this.vendorImage = vendorImage;
    }

    public String getVendorPassword() {
        return vendorPassword;
    }

    public void setVendorPassword(String vendorPassword) {
        this.vendorPassword = vendorPassword;
    }

    public String getVendorAccountType() {
        return vendorAccountType;
    }

    public void setVendorAccountType(String vendorAccountType) {
        this.vendorAccountType = vendorAccountType;
    }

    public String getVendorEmail() {
        return vendorEmail;
    }

    public void setVendorEmail(String vendorEmail) {
        this.vendorEmail = vendorEmail;
    }
}
