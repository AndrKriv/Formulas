package com.example.formulas.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.formulas.showformulas.util.Constants

@Entity(tableName = Constants.THEMES_TABLE_NAME)
data class ThemesEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "theme")
    val theme: String
)