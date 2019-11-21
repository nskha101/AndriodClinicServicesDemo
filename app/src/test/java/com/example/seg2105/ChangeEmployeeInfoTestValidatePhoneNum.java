package com.example.seg2105;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ChangeEmployeeInfoTestValidatePhoneNum {

    @Test
    public void testValidatePhoneNum() {

        String valid = "1234206969";
        String invalid = "not a phone number";

        assertTrue("test1",ChangeEmployeeInfo.validatephonenum(valid));
        assertFalse("test2",ChangeEmployeeInfo.validatephonenum(invalid));

    }
}
