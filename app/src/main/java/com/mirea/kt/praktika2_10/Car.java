package com.mirea.kt.praktika2_10;

public class Car {
    private String model;
    private String license;
    private int prYear;

    public Car(String model, String license, int prYear) {
        this.model = model;
        this.license = license;
        this.prYear = prYear;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public int getPrYear() {
        return prYear;
    }

    public void setPrYear(int prYear) {
        this.prYear = prYear;
    }
}
