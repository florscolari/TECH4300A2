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

        val btnSecondToMain = findViewById<Button>(R.id.btn_goto_main_activity)

        btnSecondToMain.setOnClickListener{
            val secondToMain = Intent(this, MainActivity::class.java)
            startActivity(secondToMain)
        }

        // Total Score, Marks & Wrong answers
        var totalScore = 0
        val marks : Int
        val wrongAnswers : Int


        // Retrieving data from Main Activity
        val i = intent
        val mainQ1Answer = i.getStringExtra("KEY_Q1_ANSWER")?.toInt()

        // Functions to check data & evaluate results
        val result: String
        val resultCorrect = 4
       if (mainQ1Answer == resultCorrect) {
           result = "Correct"
           totalScore += 1
        } else
           result = "Incorrect"
            totalScore -= 1





        // Assigning data to UI elements to be displayed on Main Activity
        val textResult = findViewById<TextView>(R.id.result)
        textResult.text = result

        // todo: add an element to display totalScore

    }
}