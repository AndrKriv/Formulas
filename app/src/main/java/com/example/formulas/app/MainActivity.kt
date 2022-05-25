package com.example.formulas.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.formulas.databinding.ActivityMainBinding

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