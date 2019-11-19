package com.example.seg2105;

import java.util.Arrays;

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

    public String getClincName(){
        return clinicName;
    }

    public Service[] getServices(){
        return services;
    }

    public HoursofOperation[] getHours() { return hours;}

    public void addService(Service service ){
        tailservice++;
        services[tailservice]=service;
    }

    public void addHours( HoursofOperation hour){
        tailhours++;
        hours[tailhours]=hour;
    }

    public void print(){
        System.out.println("Clinic Name : "+clinicName+ " Services = "+ Arrays.toString(services) + " Hours = " + Arrays.toString(hours));
    }

    public  String toString(){
        return "Clinic Name = "+clinicName+ " Services = "+ Arrays.toString(services) + " Hours = " + Arrays.toString(hours);
    }
}
