package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Medication  {

    private int id;
    private String name;
    private int guarantee;
    private String description;
    private Medication[] clash;
    private int clashSize;



    public Medication(int ID, String Name, int Guarantee, String Description) {
        this.id = ID;
        this.name = Name;
        this.guarantee = Guarantee;
        this.description = Description;
        clash = new Medication[10];
        clashSize = 0;
    }

    public String getName()
    {
        return name;
    }

    public Medication getMedication() {
        return this;
    }

    public int getID() {
        return this.id;
    }

    public void addClash(Medication m) {
        if (clashSize == 10) {
            //error message <-----------------
        } else {
            clash[clashSize] = m;
            clashSize++;
        }
    }
}