package com.example.seg2105;


public class Service {
    private String serviceName;
    private String rate;
    Service[] services;
    int tail;

    public Service(){
        services  = new Service[10];
        tail=0;
    }

    public String getServiceName(){
        return serviceName;
    }

    public String getRate(){
        return rate;
    }

    public void setServiceName(String name){
        serviceName=name;
    }

    public void setRate(String cost){
        rate = cost;
    }

    public void removeService(){
        serviceName = null;
        rate = null;
    }


    public int serviceCount(){
        return tail;
    }

}
