package com.sevvalmert.quizgame

class QuestionAnswer {

    val questions = arrayOf("Who painted the ceiling of the Sistine Chapel ?",
        "What is the smallest prime number ?",
        "Which language has the most native speakers worldwide ?",
        "What element has the chemical symbol \"Fe\" ?",
        "Which country was formerly known as Persia ?",
        "What is the name of the theory that describes the creation of the universe ?",
        "In computing, what does “HTTP” stand for ?",
        "What is the hardest natural substance on Earth ?",
        "Which planet has the shortest day (fastest rotation) ?",
        "Who wrote One Hundred Years of Solitude ?"
    )

    val answers = arrayOf(arrayOf("Leonardo da Vinci" , "Raphael" , "Caravaggio" , "Michelangelo"),
        arrayOf("0" , "1" , "2" , "3"),
        arrayOf("English" , "Spanish" , "Mandarin Chinese" , "Hindi"),
        arrayOf("Iron" , "Zinc" , "Lead" , "Fluorine"),
        arrayOf("Iraq" , "Iran" , "Turkey" , "Syria"),
        arrayOf("Evolution" , "Cosmic Flow" , "String Theory" , "Big Bang"),
        arrayOf("High-Tech Transfer Protocol" , "HyperText Transfer Protocol" , "Host Type Text Protocol" , "Hyper Transmission Text Package"),
        arrayOf("Quartz" , "Steel" , "Diamond" , "Obsidian"),
        arrayOf("Earth" , "Jupiter" , "Saturn" , "Neptune"),
        arrayOf("Gabriel García Márquez" , "Pablo Neruda" , "Isabel Allende" , "Jorge Luis Borges")
    )

    val correctAnswers = arrayOf("Michelangelo",
        "2",
        "Mandarin Chinese",
        "Iron",
        "Iran",
        "Big Bang",
        "HyperText Transfer Protocol",
        "Diamond",
        "Jupiter",
        "Gabriel García Márquez"
    )
}