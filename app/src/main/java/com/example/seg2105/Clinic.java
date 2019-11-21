package com.example.seg2105;

public class Clinic {
    private String clinicName;
    private String clinicAdress;
    private String clinicPhoneNum;
    private String clinicInsurance;
    private String clinicPayment;


    public Clinic (){
    }

    public Clinic (String clinicName, String clinicAdress, String clinicPhoneNum, String clinicInsurance, String clinicPayment){
       this.clinicName=clinicName;
       this.clinicAdress=clinicAdress;
       this.clinicPhoneNum=clinicPhoneNum;
       this.clinicInsurance=clinicInsurance;
       this.clinicPayment=clinicPayment;
    }

    public String getClincName(){
        return clinicName;
    }

    public String getClinicAdress(){return  clinicPhoneNum;}

    public String getClinicPhoneNum(){return  clinicPhoneNum;}

    public String getClinicInsurance(){return  clinicInsurance;}

    public String getClinicPayment(){return  clinicPayment;}


    public void print(){
        System.out.println("Clinic Name: "+clinicName);
    }

    public  String toString(){
        return "Clinic Name: "+ clinicName;
    }

}
