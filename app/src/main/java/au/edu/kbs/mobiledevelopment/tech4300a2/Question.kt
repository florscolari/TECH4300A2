package au.edu.kbs.mobiledevelopment.tech4300a2
// Question Types Classes

class MChoiceQType(
    private val number: Int,
    private val label: String,
    private val answer: String,
    private val operationText : String,
    private val option1 : String,
    private val option2 : String,
    private val option3 : String,
    private val feedback : String,
)
{
    fun getNumber () : Int {
        return number
    }
    fun getLabel () : String {
        return label
    }
    fun getAnswer () : String {
        return answer
    }

    fun getOperationText () : String {
        return operationText
    }

    fun getOption1 () : String {
        val option = ""
        return option1
    }
    fun getOption2 () : String {
        val option = ""
        return option2
    }
    fun getOption3 () : String {
        val option = ""
        return option3
    }
    fun getFeedback () : String {
        return feedback
    }

}

class TrueOfFalseQType(
    private val number: Int,
    private val label: String,
    private val answer: String,
    private val operationText : String,
    private val feedback : String,
    )
 {
     fun getNumber () : Int {
         return number
     }
     fun getLabel () : String {
         return label
     }
     fun getAnswer () : String {
         return answer
     }

     fun getOperationText () : String {
         return operationText
     }
    fun getTrueOption () : String {
        val option = "True"
        return option
    }

     fun getFalseOption () : String {
         val option = "False"
         return option
     }
     fun getFeedback () : String {
         return feedback
     }

}

class FillGapQType(
    private val number: Int,
    private val label: String,
    private val answer: Int,
    private val opText1 : String,
    private val opText2 : String,
    private val feedback : String,
)
{
    fun getNumber () : Int {
        return number
    }
    fun getLabel () : String {
        return label
    }
    fun getAnswer () : Int {
        return answer
    }

    fun getOpText1 () : String {
        return opText1
    }

    fun getOpText2 () : String {
        return opText2
    }

    fun getFeedback () : String {
        return feedback
    }

}


fun main() {
    val question1 = TrueOfFalseQType(1, "Is this operation correct?", "True", "5 + 4 = 9", "feedback")
    val q1Answer = question1.getTrueOption()
    println(q1Answer)

}