package com.example.moskovchuk_lesson2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val textRussian = "Первый экран"
    val textEnglish = "First screen"
    val buttonTextRU = "Дальше"
    val buttonTextENG = "Next"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val changeableText: TextView = findViewById(R.id.textView)
        val buttonNext: Button = findViewById(R.id.button_next_screen)
        val changeButton: Button = findViewById(R.id.button_change_language)
        buttonNext.text = buttonTextRU
        changeableText.text = textRussian
        changeButton.setOnClickListener{
            changeableText.text = if (changeableText.text == textRussian) {
                textEnglish
            } else {
                textRussian
            }
            buttonNext.text = if (buttonNext.text == buttonTextRU){
                buttonTextENG
            } else {
                buttonTextRU
            }
        }
        buttonNext.setOnClickListener{
            val intent = Intent(this@MainActivity, SecondScreenActivity::class.java)
            startActivity(intent)
        }

    }
}