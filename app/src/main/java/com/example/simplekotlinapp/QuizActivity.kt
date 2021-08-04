package com.example.simplekotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text


class QuizActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 0
    private var mQuestionsList: ArrayList<Question>? = null


    private var mCorrectAnswer: Int = 0
    private var mSelectedOptionPosition: Int = 0

    private lateinit var option1: TextView
    private lateinit var option2: TextView
    private lateinit var option3: TextView

    private lateinit var questionTextView: TextView
    private lateinit var btnSubmit: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        mQuestionsList = Constants.getQuestions()

        option1 = findViewById<TextView>(R.id.tv_option_one)
        option2 = findViewById<TextView>(R.id.tv_option_two)
        option3 = findViewById<TextView>(R.id.tv_option_three)
        questionTextView = findViewById(R.id.tv_question)
        btnSubmit = findViewById(R.id.btn_submit)

        option1.setOnClickListener(this)
        option2.setOnClickListener(this)
        option3.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)

        setQuestion()

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_option_one -> {
                mSelectedOptionPosition = 1
            }
            R.id.tv_option_two -> {
                mSelectedOptionPosition = 2
            }
            R.id.tv_option_three -> {
                mSelectedOptionPosition = 3
            }
            R.id.btn_submit -> {
                checkAnswer()
                mCurrentPosition += 1
                if( mCurrentPosition < mQuestionsList!!.size ) {
                    setQuestion()
                } else {
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra("score", mCorrectAnswer)
                    startActivity(intent);
                    finish()
                }
            }
        }
    }

    private fun setQuestion() {
        if (mCurrentPosition == mQuestionsList!!.size - 1) {
            btnSubmit.text = "FINISH"
        } else {
            btnSubmit.text = "SUBMIT"
        }
        val question = mQuestionsList?.get(mCurrentPosition)

        questionTextView.text = question?.question
        option1.text = question?.optionOne
        option2.text = question?.optionTwo
        option3.text = question?.optionThree
        mSelectedOptionPosition = 0
    }

    private fun checkAnswer() {
        val question = mQuestionsList?.get(mCurrentPosition)
        if( question?.correctAnswer == mSelectedOptionPosition ) {
            mCorrectAnswer++
        }
    }
}