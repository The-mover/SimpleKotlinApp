package com.example.simplekotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val restulTextView = findViewById<TextView>(R.id.tv_result)
        val score = intent.getIntExtra("score", 0)
        restulTextView.text = "Your score is: $score"
    }
}