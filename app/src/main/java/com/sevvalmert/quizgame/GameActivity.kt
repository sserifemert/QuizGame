package com.sevvalmert.quizgame

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sevvalmert.quizgame.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding
    private var timer: CountDownTimer? = null
    var correctAnswerNum : Int? = null
    var inCorrectAnswerNum : Int? = null
    var questionNum : Int = 1
    var score : Int = 0
    val randomNumberQuestionList = mutableListOf(0,1,2,3,4,5,6,7,8,9)
    private var hasNavigated = false

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


        timer?.cancel()
        val timer = object : CountDownTimer(60000,1000){
            override fun onTick(p0: Long) {
                binding.timerView.text ="${p0 / 1000}"
            }

            override fun onFinish() {
                navigateToScore()
            }
        }
        timer?.start()

        val shouldStartTimer = intent.getBooleanExtra("Timer", false)
        val tryAgainTriggered = intent.getBooleanExtra("Again", false)

        if (shouldStartTimer || tryAgainTriggered) {
            correctAnswerNum = 0
            inCorrectAnswerNum = 0
            questionNum = 1
            score = 0
            randomNumberQuestionList.clear()
            randomNumberQuestionList.addAll(0..9)
            timer.start()
            game()
        }


    }

    private fun navigateToScore() {
        if (hasNavigated) return
        hasNavigated = true
        val intent = Intent(this@GameActivity, ScoreActivity::class.java)
        intent.putExtra("correctAnswer", correctAnswerNum)
        intent.putExtra("inCorrectAnswer", inCorrectAnswerNum)
        intent.putExtra("scoreNum",score)
        startActivity(intent)
        finish()
    }

    fun game(){

        if((questionNum == 11) || randomNumberQuestionList.isEmpty()){
            navigateToScore()
            return
        }

        var questionStr = binding.questionNumView
        var scoreStr = binding.pointView

        questionStr.text = "Question ${questionNum}"
        scoreStr.text = "${score}"

        val randomNumberQuestion = randomNumberQuestionList.random()

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

        randomNumberQuestionList.remove(randomNumberQuestion)

        answer1.isEnabled = true
        answer2.isEnabled = true
        answer3.isEnabled = true
        answer4.isEnabled = true

        answer1.setBackgroundColor(Color.parseColor("#077daf"))
        answer2.setBackgroundColor(Color.parseColor("#077daf"))
        answer3.setBackgroundColor(Color.parseColor("#077daf"))
        answer4.setBackgroundColor(Color.parseColor("#077daf"))

        answer1.setOnClickListener {

            answer1.isEnabled = false
            answer2.isEnabled = false
            answer3.isEnabled = false
            answer4.isEnabled = false


            questionNum++

            if (answer1.text == correctAnswer) {
                answer1.setBackgroundColor(Color.parseColor("#2cce08"))
                correctAnswerNum = correctAnswerNum!! + 1
                score += 100
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

            Handler(Looper.getMainLooper()).postDelayed(
                {
                    game()
                },
                2000
            )

        }

        answer2.setOnClickListener {

            answer1.isEnabled = false
            answer2.isEnabled = false
            answer3.isEnabled = false
            answer4.isEnabled = false

            questionNum++

            if (answer2.text == correctAnswer) {
                answer2.setBackgroundColor(Color.parseColor("#2cce08"))
                correctAnswerNum = correctAnswerNum!! + 1
                score += 100
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

            Handler(Looper.getMainLooper()).postDelayed(
                {
                    game()
                },
                2000
            )

        }

        answer3.setOnClickListener {

            answer1.isEnabled = false
            answer2.isEnabled = false
            answer3.isEnabled = false
            answer4.isEnabled = false

            questionNum++

            if (answer3.text == correctAnswer) {
                answer3.setBackgroundColor(Color.parseColor("#2cce08"))
                correctAnswerNum = correctAnswerNum!! + 1
                score += 100

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

            Handler(Looper.getMainLooper()).postDelayed(
                {
                    game()
                },
                2000
            )
        }

        answer4.setOnClickListener {

            answer1.isEnabled = false
            answer2.isEnabled = false
            answer3.isEnabled = false
            answer4.isEnabled = false

            questionNum++

            if (answer4.text == correctAnswer) {
                answer4.setBackgroundColor(Color.parseColor("#2cce08"))
                correctAnswerNum = correctAnswerNum!! + 1
                score += 100

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

            Handler(Looper.getMainLooper()).postDelayed(
                {
                    game()
                },
                2000
            )

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
    }
}