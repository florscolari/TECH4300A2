package au.edu.kbs.mobiledevelopment.tech4300a2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMainToSecond = findViewById<Button>(R.id.btn_goto_second_activity)
        val q1Answer = findViewById<EditText>(R.id.q1UserValue)

        btnMainToSecond.setOnClickListener{
            val mainToSecond = Intent(this, SecondActivity::class.java)
            // Taking values from user input elements
            val q1AnswerValue = q1Answer.text.toString()

            // Time to send data
            mainToSecond.putExtra("KEY_Q1_ANSWER", q1AnswerValue )

            startActivity(mainToSecond)
        }

    }
}