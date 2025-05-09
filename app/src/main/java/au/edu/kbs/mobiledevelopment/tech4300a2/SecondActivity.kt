package au.edu.kbs.mobiledevelopment.tech4300a2


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isInvisible

import java.util.Locale

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // Grabbing UI elements from Second Activity
        val btnSecondToMain = findViewById<Button>(R.id.btn_goto_main_activity)
        val score = findViewById<TextView>(R.id.totalScore)
        val marksContent = findViewById<TextView>(R.id.marks)
        val wrongAnswersContent = findViewById<TextView>(R.id.wrongAnswers)
        val btnShowAnswers = findViewById<Button>(R.id.btnShowAnswers)
        val viewShowAnswers = findViewById<View>(R.id.matCard7)


        // Btn Show Answers
        viewShowAnswers.visibility = View.INVISIBLE // hidden by default
        btnShowAnswers.setOnClickListener{
            if (viewShowAnswers.isInvisible){
                viewShowAnswers.visibility = View.VISIBLE
            }
            else viewShowAnswers.visibility = View.INVISIBLE
        }

        // Btn Retake Quiz
        btnSecondToMain.setOnClickListener{
            val secondToMain = Intent(this, MainActivity::class.java)
            startActivity(secondToMain)
        }


        // Total Score, Marks & Wrong answers
        var totalScore = 0
        var marks = 0
        var wrongAnswers = 0
        val totalQuestions = 6

        // Retrieving data from Main Activity
        val i = intent
        val q1CorrectAnswer = i.getIntExtra("Q1_CORRECT_ANSWER", -1) // Fill the gap type, must come as Int to be compared
        val q1Answer = i.getStringExtra("Q1_USER_ANSWER")?.toInt()
        val q2CorrectAnswer = i.getStringExtra("Q2_CORRECT_ANSWER")
        val q2Answer = i.getStringExtra("Q2_USER_ANSWER")
        val q3CorrectAnswer = i.getStringExtra("Q3_CORRECT_ANSWER")
        val q3Answer = i.getStringExtra("Q3_USER_ANSWER")
        val q4CorrectAnswer = i.getStringExtra("Q4_CORRECT_ANSWER")
        val q4Answer = i.getStringExtra("Q4_USER_ANSWER")
        val q5CorrectAnswer = i.getIntExtra("Q5_CORRECT_ANSWER", -1) // must come as Int to be compared
        val q5Answer = i.getStringExtra("Q5_USER_ANSWER")?.toInt()
        val q6CorrectAnswer = i.getStringExtra("Q6_CORRECT_ANSWER")
        val q6Answer = i.getStringExtra("Q6_USER_ANSWER")


        // UI elements for display RIGHT Answers (coming from main activity)
        val q1RAnswer = findViewById<TextView>(R.id.q1ShowAnswer)
        val q2RAnswer = findViewById<TextView>(R.id.q2ShowAnswer)
        val q3RAnswer = findViewById<TextView>(R.id.q3ShowAnswer)
        val q4RAnswer = findViewById<TextView>(R.id.q4ShowAnswer)
        val q5RAnswer = findViewById<TextView>(R.id.q5ShowAnswer)
        val q6RAnswer = findViewById<TextView>(R.id.q6ShowAnswer)
        q1RAnswer.text = q1CorrectAnswer.toString()
        q2RAnswer.text = q2CorrectAnswer
        q3RAnswer.text = q3CorrectAnswer
        q4RAnswer.text = q4CorrectAnswer
        q5RAnswer.text = q5CorrectAnswer.toString()
        q6RAnswer.text = q6CorrectAnswer

        // UI elements for display USER Answers (coming from main activity)
        val q1UserAnswer = findViewById<TextView>(R.id.q1ShowUserAnswer)
        val q2UserAnswer = findViewById<TextView>(R.id.q2ShowUserAnswer)
        val q3UserAnswer = findViewById<TextView>(R.id.q3ShowUserAnswer)
        val q4UserAnswer = findViewById<TextView>(R.id.q4ShowUserAnswer)
        val q5UserAnswer = findViewById<TextView>(R.id.q5ShowUserAnswer)
        val q6UserAnswer = findViewById<TextView>(R.id.q6ShowUserAnswer)
        q1UserAnswer.text = q1Answer.toString()
        q2UserAnswer.text = q2Answer
        q3UserAnswer.text = q3Answer
        q4UserAnswer.text = q4Answer
        q5UserAnswer.text = q5Answer.toString()
        q6UserAnswer.text = q6Answer


        // Q1: Check data & evaluate results
        val q1Result: String
        if (q1Answer == q1CorrectAnswer) {
           q1Result = "Correct"
           totalScore += 1
           marks += 1
        } else {
            q1Result = "Incorrect"
            wrongAnswers += 1
        }

        // Q2: Check data & evaluate results
        val q2Result: String
        if (q2Answer?.trim()?.uppercase() == q2CorrectAnswer?.trim()?.uppercase()) { // to safely compare both strings
            q2Result = "Correct"
            totalScore += 1
            marks += 1
        } else {
            q2Result = "Incorrect"
            wrongAnswers += 1
        }

        // Q3: Check data & evaluate results
        val q3Result: String
        if (q3Answer?.trim()?.uppercase() == q3CorrectAnswer?.trim()?.uppercase()) { // to safely compare both strings
            q3Result = "Correct"
            totalScore += 1
            marks += 1
        } else {
            q3Result = "Incorrect"
            wrongAnswers += 1
        }

        // Q4: Check data & evaluate results
        val q4Result: String
        if (q4Answer?.trim()?.uppercase() == q4CorrectAnswer?.trim()?.uppercase()) { // to safely compare both strings
            q4Result = "Correct"
            totalScore += 1
            marks += 1
        } else {
            q4Result = "Incorrect"
            wrongAnswers += 1
        }

        // Q5: Check data & evaluate results
        val q5Result: String
        if (q5Answer == q5CorrectAnswer) {
            q5Result = "Correct"
            totalScore += 1
            marks += 1
        } else {
            q5Result = "Incorrect"
            wrongAnswers += 1
        }

        // Q6: Check data & evaluate results
        val q6Result: String
        if (q6Answer == q6CorrectAnswer) {
            q6Result = "Correct"
            totalScore += 1
            marks += 1
        } else {
            q6Result = "Incorrect"
            wrongAnswers += 1
        }


        // Converting Text Tags into Emojis kid-friendly
        fun convertTextToIcon(text:String): String {
            val correct = "Correct"
            val incorrect = "Incorrect"
            return if (text == correct) {
                text.replace(correct, "✅").trim()
            } else {
                text.replace(incorrect, "❌").trim()
            }
        }

        // Display CORRECT or INCORRECT TAGS close to user's answers & Grab UI elements
        val q1Tag = findViewById<TextView>(R.id.q1Tag)
        val q2Tag = findViewById<TextView>(R.id.q2Tag)
        val q3Tag = findViewById<TextView>(R.id.q3Tag)
        val q4Tag = findViewById<TextView>(R.id.q4Tag)
        val q5Tag = findViewById<TextView>(R.id.q5Tag)
        val q6Tag = findViewById<TextView>(R.id.q6Tag)

        // Change text to emoji
        val q1ResultEmoji = convertTextToIcon(q1Result)
        val q2ResultEmoji = convertTextToIcon(q2Result)
        val q3ResultEmoji = convertTextToIcon(q3Result)
        val q4ResultEmoji = convertTextToIcon(q4Result)
        val q5ResultEmoji = convertTextToIcon(q5Result)
        val q6ResultEmoji = convertTextToIcon(q6Result)

        // Set emoji on UI elements
        q1Tag.text = q1ResultEmoji
        q2Tag.text = q2ResultEmoji
        q3Tag.text = q3ResultEmoji
        q4Tag.text = q4ResultEmoji
        q5Tag.text = q5ResultEmoji
        q6Tag.text = q6ResultEmoji



        // Displaying total score as percentage
        val percentage: Double = totalScore.toDouble() / totalQuestions.toDouble() * 100

        // Assigning data to UI elements to be displayed on Main Activity
        score.text = String.format(Locale.ROOT, "%.0f%%", percentage)
        marksContent.text = marks.toString()
        wrongAnswersContent.text = wrongAnswers.toString()




    }
}