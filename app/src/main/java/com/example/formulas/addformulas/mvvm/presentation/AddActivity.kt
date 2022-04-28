package com.example.formulas.addformulas.mvvm.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.formulas.R
import com.example.formulas.databinding.ActivityAddBinding
import com.example.formulas.di.app.App

class AddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navAddFragment) as NavHostFragment
        val navController = navHostFragment.navController

        (applicationContext as App)
            .appComponent
            .inject(this)
    }
}