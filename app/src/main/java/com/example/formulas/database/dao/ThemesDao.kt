package com.example.formulas.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.formulas.database.model.ThemesEntity
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface ThemesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTheme(themesEntity: ThemesEntity) : Completable

    @Query("SELECT * FROM themes_table")
    fun getThemes(): Observable<List<ThemesEntity>>

    @Query("DELETE FROM themes_table where theme = :theme ")
    fun removeTheme(theme: String): Completable
}