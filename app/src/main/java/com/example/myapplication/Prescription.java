package com.example.myapplication;

import java.util.Date;

public class Prescription {
    private int id;
    private String dosage;
    private String cycle;
    private Boolean withFood;
    private Date expiryDate;

    public Prescription(int iidd, String Dosage, String Cycle, Boolean WithFood, Date ExpiryDate)
    {
        this.id = iidd;
        this.dosage = Dosage;
        this.cycle = Cycle;
        this.withFood = WithFood;
        this.expiryDate = ExpiryDate;
    }

    public Prescription getPrescription()
    {
        return this;
    }

    public int getId()
    {
        return id;
    }

    public String getDosage() {
        return dosage;
    }

    public String getCycle() {
        return cycle;
    }

    public Boolean getWithFood() {
        return withFood;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }
}
