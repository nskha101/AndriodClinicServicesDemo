package com.example.seg2105;

import org.junit.Test;

import static org.junit.Assert.*;

public class SignUpValidPasswordTest {

    @Test
    public void validatePassword() {

        String valid = "papapa123";
        //String invalid = "papa";

        assertTrue( SignUp.validatePassword(valid));

        //assertFalse(SignUp.validatePassword(invalid));
    }
}
