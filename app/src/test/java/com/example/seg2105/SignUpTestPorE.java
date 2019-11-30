package com.example.seg2105;

import org.junit.Test;

import static org.junit.Assert.*;

public class SignUpTestPorE {

    @Test
    public void validatePorE() {

        String valid = "patient";
        //String invalid = "notpatient";

        assertTrue("test1",SignUp.validatepatientorEmployee(valid));
        //assertFalse("test2",SignUp.validatepatientorEmployee(invalid));

    }
}