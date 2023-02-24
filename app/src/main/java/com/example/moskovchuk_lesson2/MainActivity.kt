package com.example.moskovchuk_lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.moskovchuk_lesson2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    //    supportFragmentManager.beginTransaction()
     //       .replace(R.id.container, AuthorizationFragment.newInstance())
     //       .commit()

        navController = Navigation.findNavController(this, R.id.navigation_container)
        setupWithNavController(binding.navView, navController)
    }
}