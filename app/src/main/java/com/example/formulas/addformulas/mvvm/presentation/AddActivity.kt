package com.example.formulas.addformulas.mvvm.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.formulas.databinding.ActivityAddBinding
import com.example.formulas.app.App
import com.example.formulas.app.MainActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class AddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navigationController =
            binding.navHostFragmentActivityBottom.getFragment<NavHostFragment>().navController
        navView.setupWithNavController(navigationController)

        (applicationContext as App)
            .appComponent
            .inject(this)
        binding.btnBack.setOnClickListener {
            backToShowData()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        backToShowData()
    }

    private fun backToShowData() {
        this.run {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}