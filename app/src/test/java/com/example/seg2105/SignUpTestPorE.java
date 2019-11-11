package com.example.seg2105;

import org.junit.Test;

import static org.junit.Assert.*;

public class SignUpTestPorE {

    @Test
    public void validatepatientorEmployee() {
        String valid = "patient";
        String valid2 = "employee";
        String invalid = "notpatientoremployee";
        SignUp su = new SignUp();

        assertTrue(su.validatepatientorEmployee()(valid));
        assertTrue(su.validatepatientorEmployee()(valid2));
        assertFalse(su.validatepatientorEmployee(invalid));

    }
}