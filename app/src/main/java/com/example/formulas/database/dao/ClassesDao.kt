package com.example.formulas.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.formulas.database.model.ClassNumberEntity
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface ClassesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertClassNumb(classNumberEntity: ClassNumberEntity): Completable

    @Query("SELECT * FROM class_table")
    fun getClassNumbers(): Observable<List<ClassNumberEntity>>

    @Query("DELETE FROM class_table where class_numb = :class_numb")
    fun removeClassNumber(class_numb: Int) : Completable
}