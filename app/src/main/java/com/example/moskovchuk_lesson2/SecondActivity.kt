package com.example.moskovchuk_lesson2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val buttonNext2 : Button = findViewById(R.id.button_next2)
        buttonNext2.setOnClickListener{
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }
}