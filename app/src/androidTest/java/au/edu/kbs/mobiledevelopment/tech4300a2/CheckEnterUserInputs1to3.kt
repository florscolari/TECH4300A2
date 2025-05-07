package au.edu.kbs.mobiledevelopment.tech4300a2


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class CheckEnterUserInputs1to3 {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkEnterUserInputs1to3 () {
        val appCompatEditText = onView(
            allOf(
                withId(R.id.q1UserValue),
                childAtPosition(
                    allOf(
                        withId(R.id.card1),
                        childAtPosition(
                            withId(R.id.matCard1),
                            0
                        )
                    ),
                    3
                )
            )
        )
        appCompatEditText.perform(scrollTo(), replaceText("4"), closeSoftKeyboard())

        val materialRadioButton = onView(
            allOf(
                withId(R.id.q2BtnFalse), withText("False"),
                childAtPosition(
                    allOf(
                        withId(R.id.q2BtnGroup),
                        childAtPosition(
                            withId(R.id.card2),
                            3
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        materialRadioButton.perform(click())

        val materialRadioButton2 = onView(
            allOf(
                withId(R.id.q3btnOption2), withText("6"),
                childAtPosition(
                    allOf(
                        withId(R.id.q3BtnGroup),
                        childAtPosition(
                            withId(R.id.card3),
                            3
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        materialRadioButton2.perform(click())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
