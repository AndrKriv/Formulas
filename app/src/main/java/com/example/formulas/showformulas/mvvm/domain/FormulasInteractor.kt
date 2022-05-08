package com.example.formulas.showformulas.mvvm.domain

import com.example.formulas.database.dao.FormulasDao
import com.example.formulas.showformulas.mvvm.model.FormulasUIModel
import com.example.formulas.util.fromEntityToInfoModelList
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FormulasInteractor @Inject constructor(
    private val formulasDao: FormulasDao
) {
    fun getFormulasByClass(classNumb: Int): Single<List<FormulasUIModel>> =
        formulasDao
            .getFormulasByClass(classNumb)
            .filter { it.isNotEmpty() }
            .toSingle()
            .map { formulas ->
                formulas.fromEntityToInfoModelList()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

//    fun insertFormulas(formulasEntity: FormulasEntity): Completable =
//        formulasDao
//            .insertData(formulasEntity)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
}