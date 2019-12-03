package com.example.seg2105;

public class Clinic {
    private String clinicName;
    private String clinicAddress;
    private String clinicPhoneNum;
    private String clinicInsurance;
    private String clinicPayment;
    private String creator;
    private double rating;
    private int waiting;
    private int numrated;


    public Clinic (){
    }

    public Clinic (String clinicName, String clinicAddress, String clinicPhoneNum, String clinicInsurance, String clinicPayment){
       this.clinicName=clinicName;
       this.clinicAddress=clinicAddress;
       this.clinicPhoneNum=clinicPhoneNum;
       this.clinicInsurance=clinicInsurance;
       this.clinicPayment=clinicPayment;
       this.rating=0;
       this.waiting=0;
       this.numrated = 0;

    }

    public Clinic (String clinicName, String clinicAddress, String clinicPhoneNum, String clinicInsurance, String clinicPayment, String creator){
        this.clinicName=clinicName;
        this.clinicAddress=clinicAddress;
        this.clinicPhoneNum=clinicPhoneNum;
        this.clinicInsurance=clinicInsurance;
        this.clinicPayment=clinicPayment;
        this.creator=creator;
        this.rating=0;
        this.waiting=0;
        this.numrated = 0;
    }

    public Clinic (String clinicName, String clinicAddress, String clinicPhoneNum, String clinicInsurance, String clinicPayment, String creator, int waiting){
        this.clinicName=clinicName;
        this.clinicAddress=clinicAddress;
        this.clinicPhoneNum=clinicPhoneNum;
        this.clinicInsurance=clinicInsurance;
        this.clinicPayment=clinicPayment;
        this.creator=creator;
        this.rating=0;
        this.waiting=waiting;
        this.numrated = 0;
    }

    public String getClinicName(){
        return clinicName;
    }

    public String getClinicAdress(){return  clinicAddress;}

    public String getClinicPhoneNum(){return  clinicPhoneNum;}

    public String getClinicInsurance(){return  clinicInsurance;}

    public int getNumrated() {
        return numrated;
    }

    public void setNumrated(int numrated) {
        this.numrated = numrated;
    }

    public String getClinicPayment(){return  clinicPayment;}

    public double getRating(){ return rating;}

    public String getCreator() { return creator;}

    public int getWaiting(){return waiting;}

    public void setClinicName(String name){clinicName = name;}

    public void setClinicAdress(String adress){clinicAddress = adress;}

    public void setClinicPhoneNum(String phoneNum){clinicPhoneNum = phoneNum;}

    public void setClinicInsurance(String insurance){clinicInsurance = insurance;}

    public void setClinicPayment(String payment){clinicPayment = payment;}

    public void setWaiting(int thisWaiting){ waiting = thisWaiting;}

    public void print(){
        System.out.println("Clinic Name: "+clinicName);
    }

    public  String toString(){
        return "Clinic Name: "+ clinicName;
    }

}
