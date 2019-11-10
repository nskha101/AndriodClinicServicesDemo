package com.example.seg2105;

import android.view.View;

import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class SignInTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    public ActivityTestRule<SignIn> siActivityTestRule = new ActivityTestRule<SignIn>(SignIn.class);
    private MainActivity mActivity = null;

    @Before
    public void setUp() throws Exception {

        mActivity = mActivityTestRule.getActivity();

        Matcher<View> buttonMacher = withId(R.id.signInButtonMain);

        onView(buttonMacher).perform(click());

        

        onView(withId(R.id.usernamefield)).perform(typeText("alexdegrace"));
        onView(withId(R.id.passwordfield)).perform(typeText("degrace1"));
        onView(withId(R.id.signInButton)).perform(click());

    }

    @Test
    public void testLaunch(){

        ViewInteraction usernameView = onView(withId(R.id.usernameID));

        

    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;

    }
}