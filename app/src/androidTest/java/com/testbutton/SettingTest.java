package com.testbutton;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.ListView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Mika on 1/11/2017.
 */
@RunWith(AndroidJUnit4.class)
public class SettingTest {
    @Rule
    public ActivityTestRule<SettingsActivity> mActivityRule =
            new ActivityTestRule<>(SettingsActivity.class);

    @Test
    public void settingsTest() {
        onView(withText("General")).check(matches(isDisplayed())).perform(click());

        mActivityRule.launchActivity(new Intent(mActivityRule.getActivity(), SettingsActivity.class));

        onView(withText("Notifications")).check(matches(isDisplayed())).perform(click());

        mActivityRule.launchActivity(new Intent(mActivityRule.getActivity(), SettingsActivity.class));

        onView(withText("Data & sync")).check(matches(isDisplayed())).perform(click());
    }


}
