package com.example.simplekotlinapp

object Constants {
    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()
        val question1 = Question(
            1,
            "Which one is the capital of BD?",
            "Dubai",
            "Dhaka",
            "Doha",
            2
        )

        val question2 = Question(
            2,
            "What is the currency of BD?",
            "Taka",
            "Rupee",
            "Dollar",
            1
        )

        questionsList.add(question1)
        questionsList.add(question2)

        return questionsList
    }
}