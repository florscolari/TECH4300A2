package au.edu.kbs.mobiledevelopment.tech4300a2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


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


        // Retrieving data from Main Activity
        val i = intent
        val mainQ1Answer = i.getStringExtra("KEY_Q1_ANSWER")?.toInt()

        // Q1: Check data & evaluate results
        val result: String
        val resultCorrect = 4
        if (mainQ1Answer == resultCorrect) {
           result = "Correct"
           totalScore ++
           marks ++
        } else {
            result = "Incorrect"
            totalScore = 0
            wrongAnswers += 1
        }




        // Assigning data to UI elements to be displayed on Main Activity
        val textResult = findViewById<TextView>(R.id.result)
        textResult.text = result
        score.text = totalScore.toString()
        marksContent.text = marks.toString()
        wrongAnswersContent.text = wrongAnswers.toString()




    }
}