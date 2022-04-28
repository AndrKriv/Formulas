package com.example.formulas.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.formulas.showformulas.util.Constants

@Entity(tableName = Constants.CLASSES_TABLE_NAME)
data class ClassNumberEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "class_numb")
    val classNumber: Int
)