package com.example.moskovchuk_lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.moskovchuk_lesson2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressBar.visibility = View.GONE


        binding.button.setOnClickListener  {
            goLoading()
        }
        binding.button2.setOnClickListener{
            goLoading()
        }
        binding.button3.setOnClickListener{
            goLoading()
        }

    }

    private fun goLoading() {
        binding.progressBar.visibility = View.INVISIBLE
        binding.button.visibility = View.GONE
        binding.button2.visibility = View.GONE
        binding.button3.visibility = View.GONE
        binding.chipGroup.visibility = View.GONE
        binding.textView5.visibility = View.GONE
    }
}