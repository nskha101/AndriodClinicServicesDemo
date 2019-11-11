package com.example.seg2105;

import org.junit.Test;

import static org.junit.Assert.*;

public class SignUpTestValidateUsername {

    @Test
    public void validateUsername() {

        String valid = "alexdegra";
        String invalid = "laaskdjeoi@";

        assertTrue("test1",SignUp.validateUsername(valid));
        assertFalse("test2",SignUp.validateUsername(invalid));

    }
}