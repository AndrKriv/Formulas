package com.example.formulas.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.formulas.core.Constants

@Entity(tableName = Constants.FORMULAS_TABLE_NAME)
data class FormulasEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "formula")
    val formula: String,
    @ColumnInfo(name = "formulas_name")
    val nameOfFormula: String,
    @ColumnInfo(name = "class_number")
    val classNumber: Int,
    @ColumnInfo(name = "theme")
    val themeOfFormulas: String,
    @ColumnInfo(name = "note")
    val noteOfFormula: String
)