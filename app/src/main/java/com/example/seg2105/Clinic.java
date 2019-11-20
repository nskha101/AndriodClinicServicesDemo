package com.example.seg2105;

public class Clinic {
    private String clinicName;


    public Clinic (){
    }

    public Clinic (String clinicName){
       this.clinicName=clinicName;
    }

    public String getClincName(){
        return clinicName;
    }

    public void print(){
        System.out.println("Clinic Name: "+clinicName);
    }

    public  String toString(){
        return "Clinic Name: "+ clinicName;
    }

}
