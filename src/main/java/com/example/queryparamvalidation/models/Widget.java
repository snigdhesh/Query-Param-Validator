package com.example.queryparamvalidation.models;

import com.example.queryparamvalidation.services.Queryable;

public class Widget {
    @Queryable
    private String productGuid;
    @Queryable
    private String serialNumber;
    @Queryable
    private String manufacturer;


    public String getProductGuid() {
        return productGuid;
    }

    public void setProductGuid(String productGuid) {
        this.productGuid = productGuid;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}