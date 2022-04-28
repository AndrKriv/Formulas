package com.example.formulas.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.formulas.database.dao.ClassesDao
import com.example.formulas.database.dao.FormulasDao
import com.example.formulas.database.dao.ThemesDao
import com.example.formulas.database.model.ClassNumberEntity
import com.example.formulas.database.model.FormulasEntity
import com.example.formulas.database.model.ThemesEntity

@Database(
    entities = [
        FormulasEntity::class,
        ClassNumberEntity::class,
        ThemesEntity::class
    ],
    version = 1,
    exportSchema = true
)
abstract class FormulasDatabase : RoomDatabase() {

    abstract fun formulasDao(): FormulasDao

    abstract fun themesDao(): ThemesDao

    abstract fun classesDao(): ClassesDao
}