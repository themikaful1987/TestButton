package com.testbutton;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Mika on 1/12/2017.
 */
@RunWith(AndroidJUnit4.class)
public class Basfa {
    private UiDevice mDevice;

    @Rule
    public ActivityTestRule<SettingsActivity> mActivityRule =
            new ActivityTestRule<>(SettingsActivity.class);

    @Test
    public void settingsTest() throws InterruptedException, UiObjectNotFoundException {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        onView(withText("General")).check(matches(isDisplayed())).perform(click());
        onView(withText("Display name")).check(matches(isDisplayed())).perform(click());

        UiObject textView = mDevice.findObject(new UiSelector().className("android.widget.EditText"));
        if (textView != null && textView.exists()) {
            textView.setText("text");
        }


        UiObject okButton = mDevice.findObject(new UiSelector().className("android.widget.Button").text("OK"));
        if (okButton != null && okButton.exists()) {
            okButton.click();
        }

        synchronized (mDevice){
            mDevice.wait(5000L);
        }
    }
}
