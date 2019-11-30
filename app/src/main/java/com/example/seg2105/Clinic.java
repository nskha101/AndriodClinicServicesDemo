package com.example.seg2105;

public class Clinic {
    private String clinicName;
    private String clinicAddress;
    private String clinicPhoneNum;
    private String clinicInsurance;
    private String clinicPayment;
    private String creator;


    public Clinic (){
    }

    public Clinic (String clinicName, String clinicAddress, String clinicPhoneNum, String clinicInsurance, String clinicPayment){
       this.clinicName=clinicName;
       this.clinicAddress=clinicAddress;
       this.clinicPhoneNum=clinicPhoneNum;
       this.clinicInsurance=clinicInsurance;
       this.clinicPayment=clinicPayment;

    }

    public Clinic (String clinicName, String clinicAddress, String clinicPhoneNum, String clinicInsurance, String clinicPayment, String creator){
        this.clinicName=clinicName;
        this.clinicAddress=clinicAddress;
        this.clinicPhoneNum=clinicPhoneNum;
        this.clinicInsurance=clinicInsurance;
        this.clinicPayment=clinicPayment;
        this.creator=creator;
    }

    public String getClinicName(){
        return clinicName;
    }

    public String getClinicAdress(){return  clinicAddress;}

    public String getClinicPhoneNum(){return  clinicPhoneNum;}

    public String getClinicInsurance(){return  clinicInsurance;}

    public String getClinicPayment(){return  clinicPayment;}

    public String getCreator() { return creator;}

    public void setClinicName(String name){clinicName = name;}

    public void setClinicAdress(String adress){clinicAddress = adress;}

    public void setClinicPhoneNum(String phoneNum){clinicPhoneNum = phoneNum;}

    public void setClinicInsurance(String insurance){clinicInsurance = insurance;}

    public void setClinicPayment(String payment){clinicPayment = payment;}


    public void print(){
        System.out.println("Clinic Name: "+clinicName);
    }

    public  String toString(){
        return "Clinic Name: "+ clinicName;
    }

}
