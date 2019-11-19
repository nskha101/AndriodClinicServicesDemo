package com.example.seg2105;

public class Clinic {
    private String clinicName;
    private Service[] services;
    private HoursofOperation[] hours;

    public Clinic (){
    }

    public Clinic (String clinicName){
        this.clinicName=clinicName;
        this.services= new Service[10];
        this.hours= new HoursofOperation[7];
    }
}
