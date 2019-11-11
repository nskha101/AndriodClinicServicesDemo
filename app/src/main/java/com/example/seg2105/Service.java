package com.example.seg2105;


public class Service {
    private String serviceName;
    private String rate;
    private String employee;

    public Service(){

    }

    public Service(String serviceName, String rate, String employee){
        this.serviceName = serviceName;
        this.rate=rate;
        this.employee = employee;
    }

    public String getServiceName(){
        return serviceName;
    }

    public String getRate(){
        return rate;
    }

    public String getEmployee() { return employee;}

    public void setServiceName(String name){
        serviceName=name;
    }

    public void setRate(String cost){
        rate = cost;
    }

    public void setEmployee (String employeename){
        employee=employeename;
    }

    public void removeService(){
        serviceName = null;
        rate = null;
    }

    public void print(){
        System.out.println("Service Name: "+serviceName+ " Rate: $"+ rate );
    }

    public String toString(){
        return this.getServiceName()+" Rate: "+ this.getRate();
    }

}
