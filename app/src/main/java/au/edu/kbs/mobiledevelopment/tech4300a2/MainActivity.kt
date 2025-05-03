package au.edu.kbs.mobiledevelopment.tech4300a2


import Question
import TrueOfFalseQType
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {



// Setting questions by using Question class
val question1 = Question(1, "Is this operation correct?", "True")
val question2 = TrueOfFalseQType(1, "Is this operation correct?", "True", "6 - 1 = 8", "Choose between True or False")




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    // Taking all UI elements to be used for a question object Q2
        val q2Number = findViewById<TextView>(R.id.q2Number)
        val q2Label = findViewById<TextView>(R.id.q2Label)
        val q2OperationText = findViewById<TextView>(R.id.q2OperationText)
        val q2BtnTrue = findViewById<Button>(R.id.btnTrue)
        val q2BtnFalse = findViewById<Button>(R.id.btnFalse)
        val q2Feedback = findViewById<TextView>(R.id.q2Feedback)

        q2Number.text = question2.getNumber().toString()
        q2Label.text = question2.getLabel()
        q2OperationText.text = question2.getOperationText()
        q2BtnTrue.text = question2.getTrueOption()
        q2BtnFalse.text = question2.getFalseOption()
        q2Feedback.text = question2.getFeedback()

        val btnMainToSecond = findViewById<Button>(R.id.btn_goto_second_activity)
        val q1Answer = findViewById<EditText>(R.id.q1UserValue)


        btnMainToSecond.setOnClickListener {
                val mainToSecond = Intent(this, SecondActivity::class.java)
                // Taking values from user input elements
                val q1AnswerValue = q1Answer.text.toString()

                // Time to send data
                mainToSecond.putExtra("KEY_Q1_ANSWER", q1AnswerValue)

                startActivity(mainToSecond)
            }

        }
    }