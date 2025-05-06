
package au.edu.kbs.mobiledevelopment.tech4300a2

class ScoreCalculator {

    fun calculateScore(
        q1User: Int?, q1Correct: Int,
        q2User: String?, q2Correct: String?,
        q3User: String?, q3Correct: String?,
        q4User: String?, q4Correct: String?,
        q5User: Int?, q5Correct: Int,
        q6User: String?, q6Correct: String?
    ): Int {
        var score = 0

        if (q1User == q1Correct) score++
        if (q2User?.trim()?.uppercase() == q2Correct?.trim()?.uppercase()) score++
        if (q3User?.trim()?.uppercase() == q3Correct?.trim()?.uppercase()) score++
        if (q4User?.trim()?.uppercase() == q4Correct?.trim()?.uppercase()) score++
        if (q5User == q5Correct) score++
        if (q6User == q6Correct) score++

        return score
    }
}
