package com.ihrsachin.apostle.model


/** Question model, with 4 options
 * @param correctOption is 0-based index of correct option (0-3)
 */
class Question(val question: String, val option1 : String, val option2 : String, val option3: String, val option4: String, val correctOption: Int)
