package com.testbutton;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Mika on 1/11/2017.
 */
@RunWith(AndroidJUnit4.class)
public class Swiperklik {

    private UiDevice mDevice;

    @Rule
    public ActivityTestRule<SettingsActivity> mActivityRule =
            new ActivityTestRule<>(SettingsActivity.class);
    @Test
    public void settingsTest() throws InterruptedException {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        onView(withText("General")).check(matches(isDisplayed())).perform(click());
        onView(withText("Enable social recommendations")).check(matches(isDisplayed())).perform(click());
        mActivityRule.launchActivity(new Intent(mActivityRule.getActivity(), SettingsActivity.class));

        onView(withText("Notifications")).check(matches(isDisplayed())).perform(click());
        onView(withText("Vibrate")).check(matches(isDisplayed())).perform(click());
        mActivityRule.launchActivity(new Intent(mActivityRule.getActivity(), SettingsActivity.class));

        onView(withText("Data & sync")).check(matches(isDisplayed())).perform(click());
        onView(withText("Sync frequency")).check(matches(isDisplayed())).perform(click());
        onView(withText("Never")).check(matches(isDisplayed())).perform(click());
        synchronized (mDevice){
            mDevice.wait(1000L);
        }
        //mDevice.pressBack();
        onView(withText("System sync settings")).check(matches(isDisplayed())).perform(click());
        //mActivityRule.launchActivity(new Intent(mActivityRule.getActivity(), SettingsActivity.class));
        //onView(withText("General")).check(matches(isDisplayed())).perform(click());
        //onView(withText("Display name")).check(matches(isDisplayed())).perform(click());
        //onView(withText("John Smith")).check(matches(isDisplayed())).perform(replaceText("MIKA"));

    }
}
