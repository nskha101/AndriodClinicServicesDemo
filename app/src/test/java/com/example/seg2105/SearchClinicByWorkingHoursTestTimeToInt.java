package com.example.seg2105;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchClinicByWorkingHoursTestTimeToInt {

    @Test
    public void TimeToIntTest() {

        String time = "14:00";
        String time2 = "4:00";

        assertTrue("test1",SearchClinicByWorkingHours.timeToInt(time)==14);
        assertTrue("test1",SearchClinicByWorkingHours.timeToInt(time2)==4);

    }
}