package au.edu.kbs.mobiledevelopment.tech4300a2


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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


        // Displaying total score as percentage
        val percentage: Double = totalScore.toDouble() / totalQuestions.toDouble() * 100

        // Assigning data to UI elements to be displayed on Main Activity
        val textResult = findViewById<TextView>(R.id.totalScore)
        textResult.text = q1Result
        score.text = String.format(Locale.ROOT, "%.0f%%", percentage)
        marksContent.text = marks.toString()
        wrongAnswersContent.text = wrongAnswers.toString()




    }
}