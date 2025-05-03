package com.sevvalmert.quizgame

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sevvalmert.quizgame.databinding.ActivityGameBinding
import com.sevvalmert.quizgame.databinding.ActivityMainBinding

class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding
    var correctAnswerNum : Int? = null
    var inCorrectAnswerNum : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityGameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        correctAnswerNum = 0
        inCorrectAnswerNum = 0

        val timer = object : CountDownTimer(10000,1000){
            override fun onTick(p0: Long) {
                binding.timerView.text ="${p0 / 1000}"
            }

            override fun onFinish() {
                val intent = Intent(this@GameActivity,ScoreActivity::class.java)
                intent.putExtra("correctAnswer",correctAnswerNum)
                intent.putExtra("inCorrectAnswer",inCorrectAnswerNum)
                startActivity(intent)
            }
        }

        val shouldStartTimer = intent.getBooleanExtra("Timer", false)

        if (shouldStartTimer) {
            timer.start()
            game()
        }

        val tryAgainTriggerd = intent.getBooleanExtra("Again",false)

        if(tryAgainTriggerd){
            timer.start()
            game()
        }


    }

    fun game(){

        val randomNumberQuestion = (0..9).random()
        println(randomNumberQuestion)

        val game = QuestionAnswer()

        val question = binding.questionView
        question.text = game.questions[randomNumberQuestion]

        val answer1 = binding.answerButton1
        answer1.text = game.answers[randomNumberQuestion][0]

        val answer2 = binding.answerButton2
        answer2.text = game.answers[randomNumberQuestion][1]

        val answer3 = binding.answerButton3
        answer3.text = game.answers[randomNumberQuestion][2]

        val answer4 = binding.answerButton4
        answer4.text = game.answers[randomNumberQuestion][3]

        val correctAnswer = game.correctAnswers[randomNumberQuestion]

        answer1.setOnClickListener {

            answer1.isEnabled = false
            answer2.isEnabled = false
            answer3.isEnabled = false
            answer4.isEnabled = false

            if (answer1.text == correctAnswer) {
                answer1.setBackgroundColor(Color.parseColor("#2cce08"))
                correctAnswerNum = correctAnswerNum!! + 1
            } else {
                answer1.setBackgroundColor(Color.parseColor("#e20938"))
                inCorrectAnswerNum = inCorrectAnswerNum!! + 1
            }

            if (answer2.text == correctAnswer) {
                answer2.setBackgroundColor(Color.parseColor("#2cce08"))

            }

            if (answer3.text == correctAnswer) {
                answer3.setBackgroundColor(Color.parseColor("#2cce08"))

            }

            if (answer4.text == correctAnswer) {
                answer4.setBackgroundColor(Color.parseColor("#2cce08"))

            }
        }

        answer2.setOnClickListener {

            answer1.isEnabled = false
            answer2.isEnabled = false
            answer3.isEnabled = false
            answer4.isEnabled = false

            if (answer2.text == correctAnswer) {
                answer2.setBackgroundColor(Color.parseColor("#2cce08"))
                correctAnswerNum = correctAnswerNum!! + 1
            } else {
                answer2.setBackgroundColor(Color.parseColor("#e20938"))
                inCorrectAnswerNum = inCorrectAnswerNum!! + 1
            }

            if (answer1.text == correctAnswer) {
                answer1.setBackgroundColor(Color.parseColor("#2cce08"))

            }

            if (answer3.text == correctAnswer) {
                answer3.setBackgroundColor(Color.parseColor("#2cce08"))

            }

            if (answer4.text == correctAnswer) {
                answer4.setBackgroundColor(Color.parseColor("#2cce08"))

            }
        }

        answer3.setOnClickListener {

            answer1.isEnabled = false
            answer2.isEnabled = false
            answer3.isEnabled = false
            answer4.isEnabled = false

            if (answer3.text == correctAnswer) {
                answer3.setBackgroundColor(Color.parseColor("#2cce08"))
                correctAnswerNum = correctAnswerNum!! + 1
            } else {
                answer3.setBackgroundColor(Color.parseColor("#e20938"))
                inCorrectAnswerNum = inCorrectAnswerNum!! + 1
            }

            if (answer1.text == correctAnswer) {
                answer1.setBackgroundColor(Color.parseColor("#2cce08"))

            }

            if (answer2.text == correctAnswer) {
                answer2.setBackgroundColor(Color.parseColor("#2cce08"))

            }

            if (answer4.text == correctAnswer) {
                answer4.setBackgroundColor(Color.parseColor("#2cce08"))

            }
        }

        answer4.setOnClickListener {

            answer1.isEnabled = false
            answer2.isEnabled = false
            answer3.isEnabled = false
            answer4.isEnabled = false

            if (answer4.text == correctAnswer) {
                answer4.setBackgroundColor(Color.parseColor("#2cce08"))
                correctAnswerNum = correctAnswerNum!! + 1
            } else {
                answer4.setBackgroundColor(Color.parseColor("#e20938"))
                inCorrectAnswerNum = inCorrectAnswerNum!! + 1
            }

            if (answer1.text == correctAnswer) {
                answer1.setBackgroundColor(Color.parseColor("#2cce08"))

            }

            if (answer2.text == correctAnswer) {
                answer2.setBackgroundColor(Color.parseColor("#2cce08"))

            }

            if (answer3.text == correctAnswer) {
                answer3.setBackgroundColor(Color.parseColor("#2cce08"))

            }
        }

    }
}