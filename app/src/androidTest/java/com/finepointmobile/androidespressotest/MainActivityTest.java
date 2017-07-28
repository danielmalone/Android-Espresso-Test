package com.finepointmobile.androidespressotest;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by danielmalone on 7/27/17.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void testName() throws Exception {

        User user = new User("Daniel", "Malone", 25);

        Espresso.onView(withId(R.id.first_name)).perform(typeText(user.getFirstName() + " is awesome!"));
        Espresso.onView(withId(R.id.first_name)).check(matches(withText("Daniel is awesome!")));
        Espresso.onView(withId(R.id.button)).perform(click());
        Espresso.onView(withId(R.id.good_name)).check(matches(withText("Good name!")));
    }

    @Test
    public void firstNameIsJake() throws Exception {
        Espresso.onView(withId(R.id.first_name)).perform(typeText("Jake"));
        Espresso.onView(withId(R.id.button)).perform(click());
        Espresso.onView(withId(R.id.good_name)).check(matches(withText("Your name is bad.")));
    }
}
