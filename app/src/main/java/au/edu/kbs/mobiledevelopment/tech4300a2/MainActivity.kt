package au.edu.kbs.mobiledevelopment.tech4300a2


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class MainActivity : AppCompatActivity() {


    // Setting questions by using Question class
    private val question1 = FillGapQType(1, "Fill the gap", 4, "5 +", "= 9", "💡 Enter a number")
    private val question2 = TrueOfFalseQType(2, "Is this operation correct?", "False", "6 - 1 = 8","💡 Choose between True or False")
    private val question3 = MChoiceQType(3, "Choose the right option", "6", "What is 2 x 3?","5", "6", "4", "💡 Choose an option")
    private val question4 = MChoiceQType(4, "Choose the right option", "7", "What is 3 + 4?","6", "9", "7", "💡 Choose an option")
    private val question5 = FillGapQType(5, "Fill the gap", 3, "6 ÷ ", "= 2", "💡 Enter a number")
    private val question6 = TrueOfFalseQType(6, "Is this operation correct?", "True", "8 ÷ 2 = 4","💡Choose between True or False")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Q1 Fill the gap: Taking all UI elements to be used for a question object Q1
        val q1Number = findViewById<TextView>(R.id.q1Number)
        val q1Label = findViewById<TextView>(R.id.q1Label)
        val q1OpText1 = findViewById<TextView>(R.id.q1OpText1)
        val q1OpText2 = findViewById<TextView>(R.id.q1OpText2)
        val q1Feedback = findViewById<TextView>(R.id.q1Feedback)
        val q1Answer = findViewById<EditText>(R.id.q1UserValue) // Taking value from user input

        q1Number.text = question1.getNumber().toString()
        q1Label.text = question1.getLabel()
        q1OpText1.text = question1.getOpText1()
        q1OpText2.text = question1.getOpText2()


        // Q2 True or False: Taking all UI elements to be used for a question object Q2
        val q2Number = findViewById<TextView>(R.id.q2Number)
        val q2Label = findViewById<TextView>(R.id.q2Label)
        val q2OperationText = findViewById<TextView>(R.id.q2OperationText)
        val q2BtnTrue = findViewById<RadioButton>(R.id.q2BtnTrue)
        val q2BtnFalse = findViewById<RadioButton>(R.id.q2BtnFalse)
        val q2Feedback = findViewById<TextView>(R.id.q2Feedback)


        q2Number.text = question2.getNumber().toString()
        q2Label.text = question2.getLabel()
        q2OperationText.text = question2.getOperationText()
        q2BtnTrue.text = question2.getTrueOption()
        q2BtnFalse.text = question2.getFalseOption()

        // Experimental section to use 2 rectangular buttons instead of default radio buttons
        fun setButtonColor(button: RadioButton, colorResId: Int) {
            val shape = ContextCompat.getDrawable(this, R.drawable.btncontainer)
            val color = ContextCompat.getColor(this, colorResId)
            shape?.setTint(color)
            button.background = shape
        }

        // Q2 setting default colors Green & Red
        setButtonColor(q2BtnTrue, R.color.colorGreen)
        setButtonColor(q2BtnFalse, R.color.colorRed)

        // changing color when each of them is clicked
        q2BtnTrue.setOnClickListener {
            q2BtnTrue.isChecked = true
            q2BtnFalse.isChecked = false

            q2BtnTrue.text = getString(R.string.trueSelected) // Adding icon as selection cue
            q2BtnFalse.text = question2.getFalseOption()

            setButtonColor(q2BtnTrue, R.color.colorGreenSelected)
            setButtonColor(q2BtnFalse, R.color.colorRed)
        }

        q2BtnFalse.setOnClickListener {
            q2BtnTrue.isChecked = false
            q2BtnFalse.isChecked = true

            q2BtnFalse.text = getString(R.string.falseSelected)  // Adding icon as selection cue
            q2BtnTrue.text = question2.getTrueOption()

            setButtonColor(q2BtnTrue, R.color.colorGreen)
            setButtonColor(q2BtnFalse, R.color.colorRedSelected)
        }


        // Q3 Multiple Choice: Taking all UI elements to be used for a question object Q3
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

        ////////// Q3 START Radio button changes
        // Q3 setting default color Blue & Blue Selected
        setButtonColor(q3BtnOption1, R.color.colorBlue)
        setButtonColor(q3BtnOption2, R.color.colorBlue)
        setButtonColor(q3BtnOption3, R.color.colorBlue)

        // changing color when each of them is clicked
        q3BtnOption1.setOnClickListener {
            q3BtnOption1.isChecked = true
            q3BtnOption2.isChecked = false
            q3BtnOption3.isChecked = false

            q3BtnOption1.text = getString(R.string.q3Option1Selected) // Adding icon as selection cue
            q3BtnOption2.text = question3.getOption2()
            q3BtnOption3.text = question3.getOption3()

            setButtonColor(q3BtnOption1, R.color.colorBlueSelected)
            setButtonColor(q3BtnOption2, R.color.colorBlue)
            setButtonColor(q3BtnOption3, R.color.colorBlue)
        }

        q3BtnOption2.setOnClickListener {
            q3BtnOption1.isChecked = false
            q3BtnOption2.isChecked = true
            q3BtnOption3.isChecked = false

            q3BtnOption1.text = question3.getOption1()
            q3BtnOption2.text = getString(R.string.q3Option2Selected) // Adding icon as selection cue
            q3BtnOption3.text = question3.getOption3()

            setButtonColor(q3BtnOption1, R.color.colorBlue)
            setButtonColor(q3BtnOption2, R.color.colorBlueSelected)
            setButtonColor(q3BtnOption3, R.color.colorBlue)
        }

        q3BtnOption3.setOnClickListener {
            q3BtnOption1.isChecked = false
            q3BtnOption2.isChecked = false
            q3BtnOption3.isChecked = true

            q3BtnOption1.text = question3.getOption1()
            q3BtnOption2.text = question3.getOption2()
            q3BtnOption3.text = getString(R.string.q3Option3Selected) // Adding icon as selection cue

            setButtonColor(q3BtnOption1, R.color.colorBlue)
            setButtonColor(q3BtnOption2, R.color.colorBlue)
            setButtonColor(q3BtnOption3, R.color.colorBlueSelected)
        }
        ////////// Q3 END Radio button changes


        // Q4 Multiple Choice: Taking all UI elements to be used for a question object Q4
        val q4Number = findViewById<TextView>(R.id.q4Number)
        val q4Label = findViewById<TextView>(R.id.q4Label)
        val q4OperationText = findViewById<TextView>(R.id.q4OperationText)
        val q4BtnOption1 = findViewById<RadioButton>(R.id.q4btnOption1)
        val q4BtnOption2 = findViewById<RadioButton>(R.id.q4btnOption2)
        val q4BtnOption3 = findViewById<RadioButton>(R.id.q4btnOption3)
        val q4Feedback = findViewById<TextView>(R.id.q4Feedback)

        q4Number.text = question4.getNumber().toString()
        q4Label.text = question4.getLabel()
        q4OperationText.text = question4.getOperationText()
        q4BtnOption1.text = question4.getOption1()
        q4BtnOption2.text = question4.getOption2()
        q4BtnOption3.text = question4.getOption3()

        ////////// Q4 START Radio button changes
        // Q4 setting default color Blue & Blue Selected
        setButtonColor(q4BtnOption1, R.color.colorBlue)
        setButtonColor(q4BtnOption2, R.color.colorBlue)
        setButtonColor(q4BtnOption3, R.color.colorBlue)

        // changing color when each of them is clicked
        q4BtnOption1.setOnClickListener {
            q4BtnOption1.isChecked = true
            q4BtnOption2.isChecked = false
            q4BtnOption3.isChecked = false

            q4BtnOption1.text = getString(R.string.q4Option1Selected) // Adding icon as selection cue
            q4BtnOption2.text = question4.getOption2()
            q4BtnOption3.text = question4.getOption3()

            setButtonColor(q4BtnOption1, R.color.colorBlueSelected)
            setButtonColor(q4BtnOption2, R.color.colorBlue)
            setButtonColor(q4BtnOption3, R.color.colorBlue)
        }

        q4BtnOption2.setOnClickListener {
            q4BtnOption1.isChecked = false
            q4BtnOption2.isChecked = true
            q4BtnOption3.isChecked = false

            q4BtnOption1.text = question4.getOption1()
            q4BtnOption2.text = getString(R.string.q4Option2Selected) // Adding icon as selection cue
            q4BtnOption3.text = question4.getOption3()

            setButtonColor(q4BtnOption1, R.color.colorBlue)
            setButtonColor(q4BtnOption2, R.color.colorBlueSelected)
            setButtonColor(q4BtnOption3, R.color.colorBlue)
        }

        q4BtnOption3.setOnClickListener {
            q4BtnOption1.isChecked = false
            q4BtnOption2.isChecked = false
            q4BtnOption3.isChecked = true

            q4BtnOption1.text = question4.getOption1()
            q4BtnOption2.text = question4.getOption2()
            q4BtnOption3.text = getString(R.string.q4Option3Selected) // Adding icon as selection cue

            setButtonColor(q4BtnOption1, R.color.colorBlue)
            setButtonColor(q4BtnOption2, R.color.colorBlue)
            setButtonColor(q4BtnOption3, R.color.colorBlueSelected)
        }
        ////////// Q4 END Radio button changes


        // Q5 Fill the gap: Taking all UI elements to be used for a question object Q5
        val q5Number = findViewById<TextView>(R.id.q5Number)
        val q5Label = findViewById<TextView>(R.id.q5Label)
        val q5OpText1 = findViewById<TextView>(R.id.q5OpText1)
        val q5OpText2 = findViewById<TextView>(R.id.q5OpText2)
        val q5Feedback = findViewById<TextView>(R.id.q5Feedback)
        val q5Answer = findViewById<EditText>(R.id.q5UserValue) // Taking value from user input

        q5Number.text = question5.getNumber().toString()
        q5Label.text = question5.getLabel()
        q5OpText1.text = question5.getOpText1()
        q5OpText2.text = question5.getOpText2()

        // Q6 True or False: Taking all UI elements to be used for a question object Q6
        val q6Number = findViewById<TextView>(R.id.q6Number)
        val q6Label = findViewById<TextView>(R.id.q6Label)
        val q6OperationText = findViewById<TextView>(R.id.q6OperationText)
        val q6BtnTrue = findViewById<RadioButton>(R.id.q6BtnTrue)
        val q6BtnFalse = findViewById<RadioButton>(R.id.q6BtnFalse)
        val q6Feedback = findViewById<TextView>(R.id.q6Feedback)

        q6Number.text = question6.getNumber().toString()
        q6Label.text = question6.getLabel()
        q6OperationText.text = question6.getOperationText()
        q6BtnTrue.text = question6.getTrueOption()
        q6BtnFalse.text = question6.getFalseOption()

        // Q6 setting default colors Green & Red
        setButtonColor(q6BtnTrue, R.color.colorGreen)
        setButtonColor(q6BtnFalse, R.color.colorRed)

        // changing color when each of them is clicked
        q6BtnTrue.setOnClickListener {
            q6BtnTrue.isChecked = true
            q6BtnFalse.isChecked = false

            q6BtnTrue.text = getString(R.string.trueSelected) // Adding icon as selection cue
            q6BtnFalse.text = question6.getFalseOption()

            setButtonColor(q6BtnTrue, R.color.colorGreenSelected)
            setButtonColor(q6BtnFalse, R.color.colorRed)
        }

        q6BtnFalse.setOnClickListener {
            q6BtnTrue.isChecked = false
            q6BtnFalse.isChecked = true

            q6BtnFalse.text = getString(R.string.falseSelected)  // Adding icon as selection cue
            q6BtnTrue.text = question6.getTrueOption()

            setButtonColor(q6BtnTrue, R.color.colorGreen)
            setButtonColor(q6BtnFalse, R.color.colorRedSelected)
        }


        // BTN: Check Results btn
        val btnMainToSecond = findViewById<Button>(R.id.btn_goto_second_activity)


        // START Reset Quiz Functionality
        // BTN: Reset Quiz btn
        val btnResetQuiz = findViewById<Button>(R.id.btnReset)
        val q2BtnRadioGroup = findViewById<RadioGroup>(R.id.q2BtnGroup)
        val q3BtnRadioGroup = findViewById<RadioGroup>(R.id.q3BtnGroup)
        val q4BtnRadioGroup = findViewById<RadioGroup>(R.id.q4BtnGroup)
        val q6BtnRadioGroup = findViewById<RadioGroup>(R.id.q6BtnGroup)
        //todo: grab the missing UI elements for this
        btnResetQuiz.setOnClickListener {
            // Q1 to Clear EditText View
            q1Answer.text.clear()

            // Q2 to Clear radio buttons: selection, text & color to rollback
            // Clearing the selection through the radio group
            q2BtnRadioGroup.clearCheck()
            // Radio Button True
            q2BtnTrue.text = question2.getTrueOption()
            setButtonColor(q2BtnTrue, R.color.colorGreen)
            // Radio Button False
            q2BtnFalse.text = question2.getFalseOption()
            setButtonColor(q2BtnFalse, R.color.colorRed)

            // Q3 to Clear radio buttons: selection, text & color to rollback
            // Clearing the selection through the radio group
            q3BtnRadioGroup.clearCheck()
            // Radio Button Opt1
            q3BtnOption1.text = question3.getOption1()
            setButtonColor(q3BtnOption1, R.color.colorBlue)
            // Radio Button Opt2
            q3BtnOption2.text = question3.getOption2()
            setButtonColor(q3BtnOption2, R.color.colorBlue)
            // Radio Button Opt3
            q3BtnOption3.text = question3.getOption3()
            setButtonColor(q3BtnOption3, R.color.colorBlue)

            // Q4 to Clear radio buttons: selection, text & color to rollback
            // Clearing the selection through the radio group
            q4BtnRadioGroup.clearCheck()
            // Radio Button Opt1
            q4BtnOption1.text = question4.getOption1()
            setButtonColor(q4BtnOption1, R.color.colorBlue)
            // Radio Button Opt2
            q4BtnOption2.text = question4.getOption2()
            setButtonColor(q4BtnOption2, R.color.colorBlue)
            // Radio Button Opt3
            q4BtnOption3.text = question4.getOption3()
            setButtonColor(q4BtnOption3, R.color.colorBlue)

            // Q5 to Clear EditText View
            q5Answer.text.clear()

            // Q6 to Clear radio buttons: selection, text & color to rollback
            // Clearing the selection through the radio group
            q6BtnRadioGroup.clearCheck()
            // Radio Button True
            q6BtnTrue.text = question6.getTrueOption()
            setButtonColor(q6BtnTrue, R.color.colorGreen)
            // Radio Button False
            q6BtnFalse.text = question6.getFalseOption()
            setButtonColor(q6BtnFalse, R.color.colorRed)
        }
        /// END Restart Functionality

        // Checking Answers before passing data to the second activity
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
        fun q4CheckAnswer() : String? {
            // To check Question 4
            return if (q4BtnOption1.isChecked) {
                q4Feedback.text = "" // trick to clear previous feedback message
                q4BtnOption1.text.toString()
            } else if (q4BtnOption2.isChecked) {
                q4Feedback.text = ""
                q4BtnOption2.text.toString()
            } else if (q4BtnOption3.isChecked) {
                q4Feedback.text = ""
                q4BtnOption3.text.toString()
            } else {
                q4Feedback.text = question4.getFeedback()
                null
            }
        }
        fun q5CheckAnswer() : String? {
            // To check Question 5
            val answerText = q5Answer.text.toString()
            return if (answerText.isNotEmpty()) {
                q5Feedback.text = "" // trick to clear previous feedback message
                answerText
            } else {
                q5Feedback.text = question5.getFeedback()
                null
            }
        }
        fun q6CheckAnswer() : String? {
            // To check Question 6
            return if (q6BtnTrue.isChecked) {
                q6Feedback.text = "" // trick to clear previous feedback message
                q6BtnTrue.text.toString()
            } else if (q6BtnFalse.isChecked) {
                q6Feedback.text = ""
                q6BtnFalse.text.toString()
            } else {
                q6Feedback.text = question6.getFeedback()
                null
            }
        }

        btnMainToSecond.setOnClickListener {
            val mainToSecond = Intent(this, SecondActivity::class.java)
            // Storing & Checking user input values from user input elements
            val q1SelectedAnswer = q1CheckAnswer()
            val q2RawAnswer = q2CheckAnswer()
            val q3RawAnswer = q3CheckAnswer()
            val q4RawAnswer = q4CheckAnswer()
            val q5SelectedAnswer = q5CheckAnswer()
            val q6RawAnswer = q6CheckAnswer()

            // if at least 1 answer is null, stop
            if (q1SelectedAnswer == null || q2RawAnswer == null || q3RawAnswer == null || q4RawAnswer == null || q5SelectedAnswer == null || q6RawAnswer == null) {
                return@setOnClickListener
            }
            // I wrote an if expression and suggests ⬆️ Elvis operator for null safety in concise way


            // CLEAN non-numerical questions before sending data
            fun cleanAnswer(text:String): String {
                return text.replace("👉", "").trim()
            }
            val q2SelectedAnswer = cleanAnswer(q2RawAnswer)
            val q3SelectedAnswer = cleanAnswer(q3RawAnswer)
            val q4SelectedAnswer = cleanAnswer(q4RawAnswer)
            val q6SelectedAnswer = cleanAnswer(q6RawAnswer)







            // Time to send data
            mainToSecond.putExtra("Q1_CORRECT_ANSWER", question1.getAnswer())
            mainToSecond.putExtra("Q1_USER_ANSWER", q1SelectedAnswer)
            mainToSecond.putExtra("Q2_CORRECT_ANSWER", question2.getAnswer())
            mainToSecond.putExtra("Q2_USER_ANSWER", q2SelectedAnswer)
            mainToSecond.putExtra("Q3_CORRECT_ANSWER", question3.getAnswer())
            mainToSecond.putExtra("Q3_USER_ANSWER", q3SelectedAnswer)
            mainToSecond.putExtra("Q4_CORRECT_ANSWER", question4.getAnswer())
            mainToSecond.putExtra("Q4_USER_ANSWER", q4SelectedAnswer)
            mainToSecond.putExtra("Q5_CORRECT_ANSWER", question5.getAnswer())
            mainToSecond.putExtra("Q5_USER_ANSWER", q5SelectedAnswer)
            mainToSecond.putExtra("Q6_CORRECT_ANSWER", question6.getAnswer())
            mainToSecond.putExtra("Q6_USER_ANSWER", q6SelectedAnswer)
            startActivity(mainToSecond)
        }
    }
}


