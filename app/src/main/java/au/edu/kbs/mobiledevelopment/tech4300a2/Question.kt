
class Question (
    private val number: Int,
    private val label: String,
    private val answer: String,
) {
     fun getNumber(): Int {
        return number
    }

     fun getLabel(): String {
        return label
    }

     fun getAnswer(): String {
        return answer
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
        val option : String = "True"
        return option
    }

     fun getFalseOption () : String {
         val option : String = "False"
         return option
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