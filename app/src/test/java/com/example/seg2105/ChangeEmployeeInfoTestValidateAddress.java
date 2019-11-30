package com.example.seg2105;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ChangeEmployeeInfoTestValidateAddress {

    @Test
    public void testValidateAddress() {

        String valid = "12 address street";
        //String invalid = "definitelynot@anaddress.ca";

        assertTrue("test1",ChangeEmployeeInfo.validateaddress(valid));
        //assertFalse("test2",ChangeEmployeeInfo.validateaddress(invalid));

    }

}
