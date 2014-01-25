package com.thoughtworks.androidbootcamp.test;

import android.test.ActivityInstrumentationTestCase2;

import com.thoughtworks.androidbootcamp.R;
import com.thoughtworks.androidbootcamp.controller.HelloAndroid;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.typeText;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;

/**
 * Functional test for the HelloAndroid activity
 */
public class HelloAndroidTest extends ActivityInstrumentationTestCase2<HelloAndroid> {

    @SuppressWarnings("deprecation")
    public HelloAndroidTest() {
        // This constructor was deprecated - but we want to support lower API levels.
        super("com.thoughtworks.androidbootcamp", HelloAndroid.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        // Espresso will not launch our activity for us, we must launch it via getActivity().
        getActivity();
    }

    public void testRetrievePlayerName() {
        onView(withId(R.id.player_field)).perform(typeText("Fred"));
        onView(withId(R.id.player_ok_button)).perform(click());

        onView(withId(R.id.welcome_player)).check(matches(withText(containsString("Fred"))));
    }
}