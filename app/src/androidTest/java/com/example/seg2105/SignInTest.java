package com.example.seg2105;

import android.view.View;

import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class SignInTest {

    @Rule
    public ActivityTestRule<SignIn> signInActivityTestRule = new ActivityTestRule<SignIn>(SignIn.class);
    private SignIn signIn = null;

    @Before
    public void setUp() throws Exception {

        signIn = signInActivityTestRule.getActivity();

    }

    @Test

    public void testLaunch(){

        ViewInteraction usernameView = onView(withId(R.id.usernameID));

        

    }

    @After
    public void tearDown() throws Exception {
        signIn = null;

    }
}