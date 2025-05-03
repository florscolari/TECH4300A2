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
        val q1Answer = i.getStringExtra("Q1_USER_ANSWER")?.toInt()
        val q2Answer = i.getStringExtra("Q2_USER_ANSWER")
        val q2CorrectAnswer = i.getStringExtra("Q2_CORRECT_ANSWER")

        // Q1: Check data & evaluate results
        val q1result: String
        val resultCorrect = 4
        if (q1Answer == resultCorrect) {
           q1result = "Correct"
           totalScore += 1
           marks += 1
        } else {
            q1result = "Incorrect"
            wrongAnswers += 1
        }

        // Q2: Check data & evaluate results
        //val question2 = TrueOfFalseQType(1, "Is this operation correct?", "True", "6 - 1 = 8", "Choose between True or False")
        val q2Result: String
        if (q2Answer == q2CorrectAnswer) {
            q2Result = "Correct"
            totalScore += 1
            marks += 1
        } else {
            q2Result = "Incorrect"
            wrongAnswers += 1
        }



        // Displaying total score as percentage
        val percentage: Double = totalScore.toDouble() / totalQuestions.toDouble() * 100

        // Assigning data to UI elements to be displayed on Main Activity
        val textResult = findViewById<TextView>(R.id.result)
        textResult.text = q1result
        score.text = String.format(Locale.ROOT, "%.0f%%", percentage)
        marksContent.text = marks.toString()
        wrongAnswersContent.text = wrongAnswers.toString()




    }
}