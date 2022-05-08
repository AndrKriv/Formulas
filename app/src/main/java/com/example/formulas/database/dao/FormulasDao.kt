package com.example.formulas.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.formulas.database.model.FormulasEntity
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface FormulasDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertData(formulasEntity: FormulasEntity): Completable

    @Query("SELECT * FROM formulas_table where class_number = :classNumb")
    fun getFormulasByClass(classNumb: Int): Single<List<FormulasEntity>>

    @Query("SELECT * FROM formulas_table where theme = :theme")
    fun getFormulasByTheme(theme: String): Single<List<FormulasEntity>>

    @Query("DELETE FROM formulas_table where formulas_name = :formulasName")
    fun removeFormula(formulasName: String)
}