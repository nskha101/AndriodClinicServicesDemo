package com.example.seg2105;

import org.junit.Test;

import static org.junit.Assert.*;

public class SignUpValidEmailTest {

    @Test
    public void validateEmail() {
        String valid = "dstew056@uottawa.ca";
        String invalid = "notavalidemail";

        assertTrue("test1",SignUp.validateEmail(valid));
        assertFalse("test2", SignUp.validateEmail(invalid));
    }
}