package pro.agfusion.moneysurfer.test.ui

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import pro.agfusion.moneysurfer.MainActivity
import pro.agfusion.moneysurfer.R


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule @JvmField
    val rule = ActivityTestRule(MainActivity::class.java, true, false)

    @Test
    fun mainActivity_startup_test() {
        rule.launchActivity(null)

        onView(withId(R.id.text)).check(matches(withText("Hello World!")))
    }
}