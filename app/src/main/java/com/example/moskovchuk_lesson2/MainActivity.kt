package com.example.moskovchuk_lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.moskovchuk_lesson2.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        openFragmentAuth(AuthorizationFragment.newInstance())
        openFragment(MainFragment.newInstance())
        openFragment(OfficesFragment.newInstance())
        openFragment(VacanciesFragment.newInstance())

 //       navView.setOnClickListener {
 //           R.id.bottom_main -> openFragment(MainFragment.newInstance())
 //           R.id.bottom_vacancies -> openFragment(VacanciesFragment.newInstance())
  //          R.id.bottom_offices -> openFragment(OfficesFragment.newInstance())
  //      }

        val navController = findNavController(R.id.navigation_container)
        val appBarConfig = AppBarConfiguration(setOf(R.id.bottom_main,
        R.id.bottom_offices, R.id.bottom_vacancies))
        setupActionBarWithNavController(navController, appBarConfig)
        navView.setupWithNavController(navController)
    }

    private fun openFragmentAuth(f: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, f)
            .commit()
    }

    private fun openFragment(f: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, f)
            .addToBackStack(null)
            .commit()
    }
}