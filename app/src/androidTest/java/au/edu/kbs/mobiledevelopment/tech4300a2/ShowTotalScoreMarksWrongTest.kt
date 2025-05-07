package au.edu.kbs.mobiledevelopment.tech4300a2

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ShowTotalScoreMarksWrongTest {

    @Test
    fun showTotalScoreMarksWrong() {
        // To launch the second activity
        ActivityScenario.launch(SecondActivity::class.java)

        // Check if totalScore is displayed
        onView(withId(R.id.totalScore)).check(matches(isDisplayed()))

        // Check if marks is displayed
        onView(withId(R.id.marks)).check(matches(isDisplayed()))

        // Check if wrongAnswers is displayed
        onView(withId(R.id.wrongAnswers)).check(matches(isDisplayed()))
    }
}
