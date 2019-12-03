package com.example.seg2105;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchClinicByAddressTestValidateAddress {

    @Test
    public void validateAddress() {

        String valid = "123 address st";
        String invalid = "#$%^&*";

        assertTrue("test1",SearchClinicByAddress.validateAddress(valid));
        assertFalse("test2",SearchClinicByAddress.validateAddress(invalid));

    }
}