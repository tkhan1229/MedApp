package com.example.myapplication;

import java.util.Date;

public class Report {

    private String patientid;
    private Date date;
    private String condition;
    private Medication med;
    private Prescription pre;

    public Report(String id, Date d, String c, Medication m, Prescription p)
    {
        this.patientid = id;
        this.date = d;
        this.condition = c;
        this.med = m;
        this.pre = p;
    }

    public Date getDate()
    {
        return date;
    }

    public String getCondition() {
        return condition;
    }

    public Medication getMed() {
        return med;
    }

    public Prescription getPre() {
        return pre;
    }
}
