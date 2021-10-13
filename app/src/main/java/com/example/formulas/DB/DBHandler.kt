package com.example.formulas.DB

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log


class DBHandler(context: Context) :
    SQLiteOpenHelper(context, DB_Info.DB_NAME, null, DB_Info.DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(DB_Info.SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DB_Info.SQL_DELETE_TABLE)
        onCreate(db)
    }
}