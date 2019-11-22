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

    public String getClinicName(){
        return clinicName;
    }

    public String getClinicAdress(){return  clinicAdress;}

    public String getClinicPhoneNum(){return  clinicPhoneNum;}

    public String getClinicInsurance(){return  clinicInsurance;}

    public String getClinicPayment(){return  clinicPayment;}

    public void setClinicName(String name){clinicName = name;}

    public void setClinicAdress(String adress){clinicAdress = adress;}

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
