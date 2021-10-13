package com.example.formulas.classes

import android.app.Activity
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.formulas.DB.DBFunc
import com.example.formulas.DB.DB_Info
import com.example.formulas.MainActivity
import com.example.formulas.R
import com.example.formulas.rec_view_adapter.Check_Adapter
import com.example.formulas.rec_view_adapter.InfoAdapter


class Classes: Activity() {
    private var znach:Int?=0
    val dbFunc = DBFunc(this)
    var db: SQLiteDatabase? = null
    companion object {
        const val TOTAL_COUNT = "total_count"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.classes)
        showNumber()

        val back_but: Button = findViewById(R.id.btn_back)
        back_but.setOnClickListener {
            back()
        }
        val find: ImageButton = findViewById(R.id.find)
        find.setOnClickListener {
            Toast.makeText(this, "search...", Toast.LENGTH_SHORT).show()
        }

    }

    private fun nameList(i:Int):List<String> {
        val data = dbFunc.readNameDB(i)
        return data
    }
    private fun formList(j:Int):List<String> {
        val data = dbFunc.readFormDB(j)
        return data
    }

    fun showNumber() {
        // Get the count from the intent extras
        val count = intent.getIntExtra(TOTAL_COUNT, 0)
        val recyclerView: RecyclerView? = findViewById(R.id.recycler_view)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        dbFunc.openDB()

        znach = count
        when (znach) {
            5 -> recyclerView?.adapter = InfoAdapter(nameList(znach!!),formList(znach!!))
            6 -> recyclerView?.adapter = InfoAdapter(nameList(znach!!),formList(znach!!))
            7 -> recyclerView?.adapter = InfoAdapter(nameList(znach!!),formList(znach!!))
            8 -> recyclerView?.adapter = InfoAdapter(nameList(znach!!),formList(znach!!))
            9 -> recyclerView?.adapter = InfoAdapter(nameList(znach!!),formList(znach!!))
            10 -> recyclerView?.adapter = InfoAdapter(nameList(znach!!),formList(znach!!))
            11 -> recyclerView?.adapter = InfoAdapter(nameList(znach!!),formList(znach!!))
            else -> Toast.makeText(this, "don't work", Toast.LENGTH_SHORT).show()
        }
    }

    private fun back(){
        val back_btn = Intent(this, MainActivity::class.java)
        startActivity(back_btn)
    }

    override fun onDestroy() {
        super.onDestroy()
        dbFunc.closeDB()
    }

}
