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
    public String getStartTime(){
        return startTime;
    }
    public String getEndTime(){
        return endTime;
    }
    public void setDay(String thisDay){ day=thisDay;}
    public void setStartTime(String thisStart){startTime=thisStart;}
    public void setEndTime(String thisEnd){endTime=thisEnd;}
}
