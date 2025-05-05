package com.sevvalmert.quizgame

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sevvalmert.quizgame.databinding.ActivityScoreBinding

class ScoreActivity : AppCompatActivity() {

    private lateinit var binding : ActivityScoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityScoreBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var getCorrectAnswer = intent.getIntExtra("correctAnswer",0)
        var getinCorrectAnswer = intent.getIntExtra("inCorrectAnswer",0)
        var getScoreNum = intent.getIntExtra("scoreNum", 0)

        var correctAnswerScore = binding.correctView
        var inCorrectAnswerScore = binding.incorrectView
        var scoreNum = binding.pointView

        correctAnswerScore.text = "${getCorrectAnswer} Corrects"
        inCorrectAnswerScore.text = "${getinCorrectAnswer} Incorrects"
        scoreNum.text = "${getScoreNum}"

    }

    fun tryAgainClicked(view : View){
        val intent = Intent(this,GameActivity::class.java)
        intent.putExtra("Again",true)
        startActivity(intent)
        finish()
    }

    fun mainMenuClicked(view : View){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}