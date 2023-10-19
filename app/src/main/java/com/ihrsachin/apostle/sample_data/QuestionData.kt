package com.ihrsachin.apostle.sample_data

import com.ihrsachin.apostle.model.Question

class QuestionData {
    companion object{
        val questionList = listOf(
            Question("What is the capital of France?", "Paris", "London", "Berlin", "Madrid", 1),
            Question("Which planet is known as the Red Planet?", "Mars", "Venus", "Jupiter", "Saturn", 1),
            Question("Who is the author of 'Harry Potter' series?", "J.K. Rowling", "George Orwell", "Agatha Christie", "Stephen King", 1),
            Question("What is the largest mammal on Earth?", "Elephant", "Giraffe", "Blue Whale", "Lion", 3),
            Question("What is the chemical symbol for water?", "O2", "H2O", "CO2", "NaCl", 2),
            Question("Which gas do plants absorb from the atmosphere?", "Oxygen", "Carbon Dioxide", "Nitrogen", "Hydrogen", 2),
            Question("In which year did Christopher Columbus discover America?", "1492", "1776", "1620", "1453", 1),
            Question("What is the largest continent on Earth?", "Africa", "North America", "Asia", "Australia", 3),
            Question("Who painted the Mona Lisa?", "Pablo Picasso", "Vincent van Gogh", "Leonardo da Vinci", "Michelangelo", 3),
            Question("What is the chemical symbol for gold?", "Fe", "Ag", "Au", "Hg", 3)
        )
    }
}