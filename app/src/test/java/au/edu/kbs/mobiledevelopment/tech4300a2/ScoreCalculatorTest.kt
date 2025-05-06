package au.edu.kbs.mobiledevelopment.tech4300a2

import org.junit.Assert.*

import org.junit.Test

 class ScoreCalculatorTest {

  @Test
  fun calculateAllCorrectAnsScore() {
  val calculator = ScoreCalculator()

  val totalScore = calculator.calculateScore(
    q1User = 5, q1Correct = 5,
    q2User = "apple", q2Correct = "Apple",
    q3User = "dog", q3Correct = "Dog",
    q4User = "sun", q4Correct = "Sun",
    q5User = 10, q5Correct = 10,
    q6User = "blue", q6Correct = "blue"
  )

  assertEquals(6, totalScore)  // all answers are correct
  }

  @Test
  fun calculateSomeCorrectAnsScore() {
   val calculator = ScoreCalculator()

   val totalScore = calculator.calculateScore(
    q1User = 3, q1Correct = 5,
    q2User = "apple", q2Correct = "Apple",
    q3User = "cat", q3Correct = "Dog",
    q4User = "Sun", q4Correct = "Sun",
    q5User = 8, q5Correct = 10,
    q6User = "blue", q6Correct = "blue"
   )

   assertEquals(3, totalScore)  // only Q2, Q4, Q6 are correct
  }

  @Test
  fun calculateNoCorrectAnsScore() {
   val calculator = ScoreCalculator()

   val totalScore = calculator.calculateScore(
    q1User = 3, q1Correct = 5,
    q2User = "apple", q2Correct = "Dog",
    q3User = "cat", q3Correct = "Banana",
    q4User = "Sun", q4Correct = "Moon",
    q5User = 8, q5Correct = 10,
    q6User = "blue", q6Correct = "sad"
   )

   assertEquals(0, totalScore)  // None are correct
  }

}