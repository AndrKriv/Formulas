package com.example.formulas.showformulas.mvvm.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.formulas.databinding.ActivityMainBinding
import com.example.formulas.di.app.App

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (applicationContext as App)
            .appComponent
            .inject(this)
    }
}