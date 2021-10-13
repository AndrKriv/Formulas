package com.example.formulas.DB

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.formulas.classes.Classes

class DBFunc (context: Context) {
    val dbHandler = DBHandler(context)
    var db:SQLiteDatabase? = null

    fun openDB(){
        db = dbHandler.writableDatabase
    }
    fun addToDb(numb_class: Int,nameOf: String, form: String){
        val values = ContentValues().apply {
            put(DB_Info.NUMB_CLASS,numb_class)
            put(DB_Info.NAME_OF_FORM,nameOf)
            put(DB_Info.FORM,form)
        }
        db?.insert(DB_Info.TABLE_NAME, null, values)

    }
    fun readNameDB(zn:Int?):ArrayList<String>{
        val dataList = ArrayList<String>()
        //db1.rawQuery(SELECT_NAME_OF_FORM_TABLE, null)
        val cursor = db?.query(
            DB_Info.TABLE_NAME,   // The table to query
            null,             // The array of columns to return (pass null to get all)
            "${DB_Info.NUMB_CLASS} = $zn",              // The columns for the WHERE clause
            null,          // The values for the WHERE clause
            null,                   // don't group the rows
            null,                   // don't filter by row groups
            null               // The sort order
        )
        while (cursor?.moveToNext()!!){
            val text = cursor.getString(cursor.getColumnIndex(DB_Info.NAME_OF_FORM))
            dataList.add(text.toString())
        }
        cursor.close()
        return dataList
    }
    fun readFormDB(zn:Int?):ArrayList<String>{
        val dataList = ArrayList<String>()
        //db1.rawQuery(SELECT_NAME_OF_FORM_TABLE, null)
        val cursor = db?.query(
            DB_Info.TABLE_NAME,   // The table to query
            null,             // The array of columns to return (pass null to get all)
            "${DB_Info.NUMB_CLASS} = $zn",              // The columns for the WHERE clause
            null,          // The values for the WHERE clause
            null,                   // don't group the rows
            null,                   // don't filter by row groups
            null               // The sort order
        )
        while (cursor?.moveToNext()!!){
            val text = cursor.getString(cursor.getColumnIndex(DB_Info.FORM))
            dataList.add(text.toString())
        }
        cursor.close()
        return dataList
    }

    fun closeDB(){
        dbHandler.close()
    }
}