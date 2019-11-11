package com.example.seg2105;

import android.content.ComponentName;
import android.view.View;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.intent.Intents;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.InstrumentationRegistry.getTargetContext;
import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static org.junit.Assert.*;

public class TestSignIn {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mActivity = null;


    @Before
    public void setUp() throws Exception {

        mActivity = mActivityTestRule.getActivity();

        Intents.init();
    }


    @Test
    public void testSignIn(){

        Matcher<View> buttonMacher = withId(R.id.signInButtonMain);

        onView(buttonMacher).perform(click());

        onView(withId(R.id.usernameID)).perform(typeText("alexdegrace"));
        onView(withId(R.id.usernameID)).check(matches(withText("alexdegrace")));

        onView(withId(R.id.passwordID)).perform(typeText("degrace1"));
        onView(withId(R.id.passwordID)).check(matches(withText("degrace1")));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.signInButton)).perform(click());
        intended(hasComponent(WelcomeScreen.class.getName()));

    }


    @After
    public void tearDown() throws Exception {
        mActivity = null;

    }
}