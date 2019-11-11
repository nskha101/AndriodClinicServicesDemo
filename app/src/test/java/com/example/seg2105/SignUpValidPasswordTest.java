package com.example.seg2105;

import org.junit.Test;

import static org.junit.Assert.*;

public class SignUpValidPasswordTest {

    @Test
    public void validatePassword() {

        String valid = "dstew056@uottawa.ca";
        String invalid = "notavalidemail";

        assertTrue( SignUp.validatePassword(valid));

        assertFalse( SignUp.validatePassword(invalid));
    }
}
