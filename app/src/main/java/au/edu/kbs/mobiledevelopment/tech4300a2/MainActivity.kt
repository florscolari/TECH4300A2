package au.edu.kbs.mobiledevelopment.tech4300a2


import FillGapQType
import Question
import TrueOfFalseQType
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {


    // Setting questions by using Question class
    private val question1 = FillGapQType(1, "Fill the gap", 4, "5 +", "= 9", "Enter a number")
    private val question2 = TrueOfFalseQType(2, "Is this operation correct?", "True", "6 - 1 = 8","Choose between True or False")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Taking all UI elements to be used for a question object Q1
        val q1Number = findViewById<TextView>(R.id.q1Number)
        val q1Label = findViewById<TextView>(R.id.q1Label)
        val q1OpText1 = findViewById<TextView>(R.id.q1OpText1)
        val q1OpText2 = findViewById<TextView>(R.id.q1OpText2)
        val q1Feedback = findViewById<TextView>(R.id.q1Feedback)

        q1Number.text = question1.getNumber().toString()
        q1Label.text = question1.getLabel()
        q1OpText1.text = question1.getOpText1()
        q1OpText2.text = question1.getOpText2()

        val q1Answer = findViewById<EditText>(R.id.q1UserValue)


        fun q1CheckAnswer() : String? {
            // To check Question 1
            val answerText = q1Answer.text.toString()
            return if (answerText.isNotEmpty()) {
                answerText
            } else {
                q1Feedback.text = question1.getFeedback()
                null// it's working!!
            }
        }





        // Taking all UI elements to be used for a question object Q2
        val q2Number = findViewById<TextView>(R.id.q2Number)
        val q2Label = findViewById<TextView>(R.id.q2Label)
        val q2OperationText = findViewById<TextView>(R.id.q2OperationText)
        val q2BtnTrue = findViewById<RadioButton>(R.id.btnTrue)
        val q2BtnFalse = findViewById<RadioButton>(R.id.btnFalse)
        val q2Feedback = findViewById<TextView>(R.id.q2Feedback)

        q2Number.text = question2.getNumber().toString()
        q2Label.text = question2.getLabel()
        q2OperationText.text = question2.getOperationText()
        q2BtnTrue.text = question2.getTrueOption()
        q2BtnFalse.text = question2.getFalseOption()


        val btnMainToSecond = findViewById<Button>(R.id.btn_goto_second_activity)






        fun q2CheckAnswer() : String? {
            // To check Question 2
            return if (q2BtnTrue.isChecked) {
                q2BtnTrue.text.toString()
            } else if (q2BtnFalse.isChecked) {
                q2BtnFalse.text.toString()
            } else {
                q2Feedback.text = question2.getFeedback()
                null// it's working!!
            }
        }
        btnMainToSecond.setOnClickListener {
            val mainToSecond = Intent(this, SecondActivity::class.java)
            // Storing & Checking user input values from user input elements
            val q1SelectedAnswer = q1CheckAnswer()
            val q2SelectedAnswer = q2CheckAnswer()

            // if at least 1 answer is null, stop
            if (q1SelectedAnswer == null || q2SelectedAnswer == null) {
                return@setOnClickListener
            }
            // I wrote an if expression and suggests ⬆️ Elvis operator for null safety in concise way

            // Time to send data
            mainToSecond.putExtra("Q1_USER_ANSWER", q1SelectedAnswer)
            mainToSecond.putExtra("Q2_CORRECT_ANSWER", question2.getAnswer())
            mainToSecond.putExtra("Q2_USER_ANSWER", q2SelectedAnswer)
            startActivity(mainToSecond)
        }
    }
}


