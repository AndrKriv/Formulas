package com.example.formulas.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.formulas.data.database.model.ClassNumberEntity
import io.reactivex.Single

@Dao
interface ClassesDao {

    @Query("SELECT * FROM class_table")
    fun getClassNumbers(): Single<List<ClassNumberEntity>>
}