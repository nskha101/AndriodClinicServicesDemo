package com.example.seg2105;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchClinicByWorkingHoursTestValidateTimes {

    @Test
    public void ValidateTimesTest() {

        String time = "14:00";
        String time2 = "4:00";

        assertTrue("test1",SearchClinicByWorkingHours.validateTimes(time2,time));
        assertFalse("test1",SearchClinicByWorkingHours.validateTimes(time,time2));

    }
}