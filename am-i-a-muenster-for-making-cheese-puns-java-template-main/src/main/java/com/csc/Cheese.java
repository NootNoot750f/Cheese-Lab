package com.csc;

public class Cheese {
    private String milkTreatment;
    private boolean isOrganic;
    private double moisturePercent;
    private String milkType;

    public Cheese(String milkTreatment, boolean isOrganic, double moisturePercent, String milkType) {
        this.milkTreatment = milkTreatment;
        this.isOrganic = isOrganic;
        this.moisturePercent = moisturePercent;
        this.milkType = milkType;
    }

    public String getMilkTreatment() {
        return milkTreatment;
    }

    public boolean isOrganic() {
        return isOrganic;
    }

    public double getMoisturePercent() {
        return moisturePercent;
    }

    public String getMilkType() {
        return milkType;
    }
}
