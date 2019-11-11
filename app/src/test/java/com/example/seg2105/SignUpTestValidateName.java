package com.example.seg2105;

import org.junit.Test;

import static org.junit.Assert.*;

public class SignUpTestValidateName {

    @Test
    public void validateName() {
        String valid = "David";
        String invalid = "D@v1d";
        SignUp su = new SignUp();

        assertTrue(su.validateName(valid));
        assertFalse(su.validateName(invalid));
    }
}