package au.edu.kbs.mobiledevelopment.tech4300a2


import Question
import TrueOfFalseQType
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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