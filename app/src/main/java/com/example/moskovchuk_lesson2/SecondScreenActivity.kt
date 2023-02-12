package com.example.moskovchuk_lesson2

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondScreenActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)
        val buttonBack : Button = findViewById(R.id.button_back)
        val editText : EditText = findViewById(R.id.edit_text)
        //Edit text сохраняет информацию при повороте экрана
        val textFromEditText = editText.text.toString()


        buttonBack.setOnClickListener{
            val intentForSecondScreen = Intent(this, MainActivity::class.java)
            intentForSecondScreen.putExtra(MainActivity.TEXT, textFromEditText.toString())
            startActivity(intentForSecondScreen)
        }


    }


}