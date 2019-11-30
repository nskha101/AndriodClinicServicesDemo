package com.example.seg2105;

import org.junit.Test;

import static org.junit.Assert.*;

public class SignUpTestValidateName {

    @Test
    public void validateName() {

        String valid = "alex";
        //String invalid = "al5ex@@";

        assertTrue("test1",SignUp.validateName(valid));
        //assertFalse("test2",SignUp.validateName(invalid));

    }
}