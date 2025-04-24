package com.sevvalmert.quizgame

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sevvalmert.quizgame.databinding.ActivityGameBinding
import com.sevvalmert.quizgame.databinding.ActivityMainBinding

class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding

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


        val timer = object : CountDownTimer(90000,1000){
            override fun onTick(p0: Long) {
                binding.timerView.text ="${p0 / 1000}"
            }

            override fun onFinish() {
                val intent = Intent(this@GameActivity,ScoreActivity::class.java)
                startActivity(intent)
            }
        }

        val shouldStartTimer = intent.getBooleanExtra("Timer", false)

        if (shouldStartTimer) {
            timer.start()
        }


    }
}