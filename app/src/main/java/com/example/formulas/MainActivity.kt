package com.example.formulas

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.formulas.classes.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button5: Button = findViewById(R.id.class_5)
        button5.setOnClickListener {
            check(5)
        }
        val button6: Button = findViewById(R.id.class_6)
        button6.setOnClickListener {
            check(6)
        }
        val button7: Button = findViewById(R.id.class_7)
        button7.setOnClickListener {
            check(7)
        }
        val button8: Button = findViewById(R.id.class_8)
        button8.setOnClickListener {
            check(8)
        }
        val button9: Button = findViewById(R.id.class_9)
        button9.setOnClickListener {
            check(9)
        }
        val button10: Button = findViewById(R.id.class_10)
        button10.setOnClickListener {
            check(10)
        }
        val button11: Button = findViewById(R.id.class_11)
        button11.setOnClickListener {
            check(11)
        }
    }

    fun check(i:Int) {
        val classIntent = Intent(this, Classes::class.java)
        startActivity(classIntent)
        classIntent.putExtra(Classes.TOTAL_COUNT, i)
        startActivity(classIntent)
    }
}