package com.example.moskovchuk_lesson2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val textRussian = "Первый экран"
    private val textEnglish = "First screen"
    private val buttonTextRU = "Дальше"
    private val buttonTextENG = "Next"
    private val changeableText: TextView = findViewById(R.id.textView)
    private val buttonNext: Button = findViewById(R.id.button_next_screen)
    private val changeButton: Button = findViewById(R.id.button_change_language)
    private val someText : TextView = findViewById(R.id.textView2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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

        val textFromSecondScreen = intent.getStringExtra(TEXT)

        when (textFromSecondScreen) {
            null -> {someText.text}
            someText.text -> { }
            else -> {someText.text = textFromSecondScreen}
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putString("KEY", someText.text.toString())
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        someText.text = savedInstanceState.getString("KEY")
    }


    companion object {
        const val TEXT = "text_from_second_screen"
    }
}


