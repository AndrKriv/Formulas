package com.example.formulas.showformulas.mvvm.domain

import com.example.formulas.database.dao.FormulasDao
import com.example.formulas.database.model.ClassNumbWithFormulas
import com.example.formulas.database.model.FormulasEntity
import com.example.formulas.fromEntityToInfoModelList
import com.example.formulas.showformulas.mvvm.core.InfoModel
import io.reactivex.Single
import javax.inject.Inject

class FormulasInteractor @Inject constructor(
    private val formulasDao: FormulasDao
) {
    fun insertData(formulasEntity: FormulasEntity) =
        formulasDao.insertData(formulasEntity)

    fun insertDataList(list: List<FormulasEntity>) {
        for (i in list) {
            insertData(i)
        }
    }

    fun getFormulasByClass(classNumb: Int): Single<List<FormulasEntity>> =
        formulasDao
            .getFormulasByClass(classNumb)

//    private fun deleteData(themesEntity: ThemesEntity) =
//        formulasDao.deleteTheme(themesEntity)
}