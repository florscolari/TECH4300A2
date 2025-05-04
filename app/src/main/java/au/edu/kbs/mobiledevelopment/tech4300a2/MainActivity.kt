package au.edu.kbs.mobiledevelopment.tech4300a2


import android.content.Intent
import android.os.Bundle
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
    private val question2 = TrueOfFalseQType(2, "Is this operation correct?", "False", "6 - 1 = 8","Choose between True or False")
    private val question3 = MChoiceQType(3, "Choose the right option", "6", "What is 2 x 3?","5", "6", "4", "Choose one option")


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
                q1Feedback.text = "" // trick to clear previous feedback message
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




        // Taking all UI elements to be used for a question object Q3
        val q3Number = findViewById<TextView>(R.id.q3Number)
        val q3Label = findViewById<TextView>(R.id.q3Label)
        val q3OperationText = findViewById<TextView>(R.id.q3OperationText)
        val q3BtnOption1 = findViewById<RadioButton>(R.id.q3btnOption1)
        val q3BtnOption2 = findViewById<RadioButton>(R.id.q3btnOption2)
        val q3BtnOption3 = findViewById<RadioButton>(R.id.q3btnOption3)
        val q3Feedback = findViewById<TextView>(R.id.q3Feedback)

        q3Number.text = question3.getNumber().toString()
        q3Label.text = question3.getLabel()
        q3OperationText.text = question3.getOperationText()
        q3BtnOption1.text = question3.getOption1()
        q3BtnOption2.text = question3.getOption2()
        q3BtnOption3.text = question3.getOption3()



        val btnMainToSecond = findViewById<Button>(R.id.btn_goto_second_activity)






        fun q2CheckAnswer() : String? {
            // To check Question 2
            return if (q2BtnTrue.isChecked) {
                q2Feedback.text = "" // trick to clear previous feedback message
                q2BtnTrue.text.toString()
            } else if (q2BtnFalse.isChecked) {
                q2Feedback.text = ""
                q2BtnFalse.text.toString()
            } else {
                q2Feedback.text = question2.getFeedback()
                null// it's working!!
            }
        }
        fun q3CheckAnswer() : String? {
            // To check Question 3
            return if (q3BtnOption1.isChecked) {
                q3Feedback.text = "" // trick to clear previous feedback message
                q3BtnOption1.text.toString()
            } else if (q3BtnOption2.isChecked) {
                q3Feedback.text = ""
                q3BtnOption2.text.toString()
            } else if (q3BtnOption3.isChecked) {
                q3Feedback.text = ""
                q3BtnOption3.text.toString()
            } else {
                q3Feedback.text = question3.getFeedback()
                null
            }
        }




        btnMainToSecond.setOnClickListener {
            val mainToSecond = Intent(this, SecondActivity::class.java)
            // Storing & Checking user input values from user input elements
            val q1SelectedAnswer = q1CheckAnswer()
            val q2SelectedAnswer = q2CheckAnswer()
            val q3SelectedAnswer = q3CheckAnswer()

            // if at least 1 answer is null, stop
            if (q1SelectedAnswer == null || q2SelectedAnswer == null || q3SelectedAnswer == null) {
                return@setOnClickListener
            }
            // I wrote an if expression and suggests ⬆️ Elvis operator for null safety in concise way

            // Time to send data
            mainToSecond.putExtra("Q1_CORRECT_ANSWER", question1.getAnswer())
            mainToSecond.putExtra("Q1_USER_ANSWER", q1SelectedAnswer)
            mainToSecond.putExtra("Q2_CORRECT_ANSWER", question2.getAnswer())
            mainToSecond.putExtra("Q2_USER_ANSWER", q2SelectedAnswer)
            mainToSecond.putExtra("Q3_CORRECT_ANSWER", question3.getAnswer())
            mainToSecond.putExtra("Q3_USER_ANSWER", q3SelectedAnswer)
            startActivity(mainToSecond)
        }
    }
}


