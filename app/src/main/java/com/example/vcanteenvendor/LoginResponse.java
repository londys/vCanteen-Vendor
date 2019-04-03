package com.example.vcanteenvendor;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("vendorToken")
    private String token;

    @SerializedName("vendorId")
    private String vendor_id;

    public String getStatus() {
        return status;
    }

    public String getToken() {
        return token;
    }

    public String getVendor_id() {
        return vendor_id;
    }
}
