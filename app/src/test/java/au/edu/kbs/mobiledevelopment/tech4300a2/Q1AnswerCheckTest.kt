package au.edu.kbs.mobiledevelopment.tech4300a2

import org.junit.Assert.*

import org.junit.Test

 class Q1AnswerCheckTest {
  // I need to instantiate the class Q1AnswerCheck first to then use its method (fun isQ1AnswerCorrect)
  val checker = Q1AnswerCheck()

  @Test
  fun answerCorrect_returnsTrue() {
    assertTrue(checker.isQ1AnswerCorrect("5"))  // should return True
  }

  @Test
  fun answerIncorrect_returnsFalse() {
   assertFalse(checker.isQ1AnswerCorrect("4"))  // should return False
  }

  @Test
  fun answerEmpty_returnsFalse() {
   assertFalse(checker.isQ1AnswerCorrect(""))  // should return False
  }

  @Test
  fun answerNull_returnsFalse() {
   assertFalse(checker.isQ1AnswerCorrect(null))  // should return False
  }
 }