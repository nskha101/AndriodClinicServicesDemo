package com.example.seg2105;

import java.sql.Time;

public class Hours {
    private String day;
    private Time startTime;
    private Time endTime;

    public Hours(){}

    public Hours(String day, Time startTime, Time endTime){

        this.day=day;
        this.startTime=startTime;
        this.endTime=endTime;

    }

    public String getDay(){
        return day;
    }
    public Time getTimefrom(){
        return startTime;
    }
    public Time getTimeto(){
        return endTime;
    }
}
