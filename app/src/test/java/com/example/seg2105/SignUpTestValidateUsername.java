package com.example.seg2105;

import org.junit.Test;

import static org.junit.Assert.*;

public class SignUpTestValidateUsername {

    @Test
    public void validateUsername() {

        String valid = "username";
        String invalid = "user";
        String invalid2 = "usernametoobig";
        SignUp su = new SignUp()

        assertTrue(su.validateUsername(valid));
        assertFalse(su.validateUsername(invalid));
        assertFalse(su.validateUsername(invalid2));
    }
}