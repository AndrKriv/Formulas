package com.example.formulas.domain.interactor

import com.example.formulas.data.database.dao.FormulasDao
import com.example.formulas.data.database.dao.ThemesDao
import com.example.formulas.data.database.model.FormulasEntity
import com.example.formulas.extension.fromEntityToInfoModelList
import com.example.formulas.extension.fromThemesEntityListToStringList
import com.example.formulas.presentation.info.model.InfoUIModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FormulasInteractor @Inject constructor(
    private val formulasDao: FormulasDao,
    private val themesDao: ThemesDao
) {
    fun getFormulasByClass(classNumb: Int): Single<List<InfoUIModel>> =
        formulasDao
            .getFormulasByClass(classNumb)
            .filter { list -> list.isNotEmpty() }
            .toSingle()
            .map { formulas ->
                formulas.fromEntityToInfoModelList()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun getFormulasByTheme(theme: String): Single<List<InfoUIModel>> =
        formulasDao
            .getFormulasByTheme(theme)
            .filter { list -> list.isNotEmpty() }
            .toSingle()
            .map { formulas ->
                formulas.fromEntityToInfoModelList()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun getThemes(): Single<List<String>> =
        themesDao
            .getThemes()
            .map { themeEntityList ->
                themeEntityList.fromThemesEntityListToStringList()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    suspend fun insert(formulasEntity: FormulasEntity) = formulasDao.insertData(formulasEntity)
    suspend fun delete(formName: String) = formulasDao.removeFormula(formName)
}