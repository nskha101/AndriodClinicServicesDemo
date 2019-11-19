package com.example.seg2105;

public class Clinic {
    private String clinicName;
    private Service[] services;
    private HoursofOperation[] hours;
    int tailservice= -1;
    int tailhours=-1;



    public Clinic (){
    }

    public Clinic (String clinicName){
        this.clinicName=clinicName;
        this.services= new Service[10];
        this.hours= new HoursofOperation[7];
    }

    public void addService(Service service ){
        tailservice++;
        services[tailservice]=service;
    }

    public void addHours( HoursofOperation hour){
        tailhours++;
        hours[tailhours]=hour;
    }
}
