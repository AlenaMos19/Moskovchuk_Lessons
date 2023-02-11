package com.example.moskovchuk_lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.moskovchuk_lesson2.R

class MainActivity : AppCompatActivity() {

    val textRussian = "Первый экран"
    val textEnglish = "First screen"
    val buttonTextRU = "Дальше"
    val buttonTextENG = "Next"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val changeableText: TextView = findViewById(R.id.textView)
        val changeableButtonText: Button = findViewById(R.id.button_next_screen)
        val changeButton: Button = findViewById(R.id.button_change_language)
        changeableButtonText.text = buttonTextRU
        changeableText.text = textRussian
        changeButton.setOnClickListener{
            changeableText.text = if (changeableText.text == textRussian) {
                textEnglish
            } else {
                textRussian
            }
            changeableButtonText.text = if (changeableButtonText.text == buttonTextRU){
                buttonTextENG
            } else {
                buttonTextRU
            }
        }

    }
}