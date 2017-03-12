package com.testbutton;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.addGlobalAssertion;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by marjancvetkovic on 10/01/2017.
 */
@RunWith(AndroidJUnit4.class)
public class Test2 {
    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule =
            new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void testLoginData() {
        onView(withId(R.id.email))
                .perform(typeText("Milan"), closeSoftKeyboard());
        onView(withId(R.id.password))
                .perform(typeText("Milan"), closeSoftKeyboard());

        onView(withId(R.id.email_sign_in_button)).perform(click());
    }
}


