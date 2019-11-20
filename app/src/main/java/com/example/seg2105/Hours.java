package com.example.seg2105;

import java.sql.Time;

public class Hours {
    private String day;
    private String startTime;
    private String endTime;

    public Hours(){}

    public Hours(String day, String startTime, String endTime){

        this.day=day;
        this.startTime=startTime;
        this.endTime=endTime;

    }

    public String getDay(){
        return day;
    }
    public String getTimefrom(){
        return startTime;
    }
    public String getTimeto(){
        return endTime;
    }
}
