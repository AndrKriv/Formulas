package com.example.formulas.database.model

import androidx.room.*
import androidx.room.ForeignKey.CASCADE
import com.example.formulas.showformulas.util.Constants

@Entity(tableName = Constants.FORMULAS_TABLE_NAME)
data class FormulasEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "class_number")
    val classNumber: Int,
    @ColumnInfo(name = "formulas_name")
    val nameOf: String,
    @ColumnInfo(name = "formula")
    val formula: String,
    @ColumnInfo(name = "theme")
    val theme: String
)