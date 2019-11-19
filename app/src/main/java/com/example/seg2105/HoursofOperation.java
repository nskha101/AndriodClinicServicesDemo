package com.example.seg2105;

import java.sql.Time;

public class HoursofOperation {
    private String day;
    private String timefrom;
    private String timeto;

    public HoursofOperation (){

    }
    public HoursofOperation (String day, String timefrom,String timeto){
        this.day = day;
        this.timefrom = timefrom;
        this.timeto = timeto;
    }

    public String getDay(){
        return day;
    }
    public String getTimefrom(){
        return timefrom;
    }
    public String getTimeto(){
        return timeto;
    }
}
