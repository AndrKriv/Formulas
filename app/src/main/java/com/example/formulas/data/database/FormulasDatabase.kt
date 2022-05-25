package com.example.formulas.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.formulas.data.database.dao.ClassesDao
import com.example.formulas.data.database.dao.FormulasDao
import com.example.formulas.data.database.dao.ThemesDao
import com.example.formulas.data.database.model.ClassNumberEntity
import com.example.formulas.data.database.model.FormulasEntity
import com.example.formulas.data.database.model.ThemesEntity

@Database(
    entities = [
        FormulasEntity::class,
        ClassNumberEntity::class,
        ThemesEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class FormulasDatabase : RoomDatabase() {

    abstract fun formulasDao(): FormulasDao

    abstract fun themesDao(): ThemesDao

    abstract fun classesDao(): ClassesDao
}