package com.example.seg2105;


public class Service {
    private String serviceName;
    private String rate;
    private String type;

    public Service(){

    }

    public Service(String serviceName, String rate, String type){
        this.serviceName = serviceName;
        this.rate=rate;
        this.type = type;
    }

    public String getServiceName(){
        return serviceName;
    }

    public String getRate(){
        return rate;
    }

    public String getType() { return type;}

    public void setServiceName(String name){
        serviceName=name;
    }

    public void setRate(String cost){
        rate = cost;
    }

    public void setType (String servicetype){
        type=servicetype;
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
