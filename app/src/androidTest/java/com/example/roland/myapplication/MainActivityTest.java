package com.example.roland.myapplication;


import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import junit.framework.Assert;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.RunWith;

import javax.sql.DataSource;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.res_val), withText("RESISTANCE"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatSpinner = onView(
                allOf(withId(R.id.spinner2), isDisplayed()));
        appCompatSpinner.perform(click());

        DataInteraction relativeLayout = onData(
                allOf(withId(android.R.layout.simple_spinner_item), isDisplayed())).atPosition(0);
        relativeLayout.perform(click());

        ViewInteraction appCompatSpinner2 = onView(
                allOf(withId(R.id.spinner3), isDisplayed()));
        appCompatSpinner2.perform(click());

        ViewInteraction relativeLayout2 = onView(
                allOf(withClassName(is("android.widget.RelativeLayout")), isDisplayed()));
        relativeLayout2.perform(click());

        ViewInteraction appCompatSpinner3 = onView(
                allOf(withId(R.id.spinner4), isDisplayed()));
        appCompatSpinner3.perform(click());

        ViewInteraction relativeLayout3 = onView(
                allOf(withClassName(is("android.widget.RelativeLayout")), isDisplayed()));
        relativeLayout3.perform(click());

        ViewInteraction appCompatSpinner4 = onView(
                allOf(withId(R.id.spinner1), isDisplayed()));
        appCompatSpinner4.perform(click());

        ViewInteraction appCompatCheckedTextView = onView(
                allOf(withId(android.R.id.text1), withText("5"), isDisplayed()));
        appCompatCheckedTextView.perform(click());

        ViewInteraction appCompatSpinner5 = onView(
                allOf(withId(R.id.spinner2), isDisplayed()));
        appCompatSpinner5.perform(click());

        ViewInteraction relativeLayout4 = onView(
                allOf(withClassName(is("android.widget.RelativeLayout")), isDisplayed()));
        relativeLayout4.perform(click());

        ViewInteraction appCompatSpinner6 = onView(
                allOf(withId(R.id.spinner3), isDisplayed()));
        appCompatSpinner6.perform(click());

        ViewInteraction relativeLayout5 = onView(
                allOf(withClassName(is("android.widget.RelativeLayout")), isDisplayed()));
        relativeLayout5.perform(click());

        ViewInteraction appCompatSpinner7 = onView(
                allOf(withId(R.id.spinner4), isDisplayed()));
        appCompatSpinner7.perform(click());

        ViewInteraction relativeLayout6 = onView(
                allOf(withClassName(is("android.widget.RelativeLayout")), isDisplayed()));
        relativeLayout6.perform(click());

        ViewInteraction appCompatSpinner8 = onView(
                allOf(withId(R.id.spinner5), isDisplayed()));
        appCompatSpinner8.perform(click());

        ViewInteraction relativeLayout7 = onView(
                allOf(withClassName(is("android.widget.RelativeLayout")), isDisplayed()));
        relativeLayout7.perform(click());

        ViewInteraction appCompatSpinner9 = onView(
                allOf(withId(R.id.spinner6), isDisplayed()));
        appCompatSpinner9.perform(click());

        ViewInteraction relativeLayout8 = onView(
                allOf(withClassName(is("android.widget.RelativeLayout")), isDisplayed()));
        relativeLayout8.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.home), withText("HOME"), isDisplayed()));
        appCompatButton2.perform(click());

    }

}
