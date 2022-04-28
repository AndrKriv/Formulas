package com.example.formulas.addformulas.mvvm.domain

import com.example.formulas.database.dao.FormulasDao
import com.example.formulas.database.model.FormulasEntity
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AddFormulasInteractor @Inject constructor(
    private val formulasDao: FormulasDao
) {

    fun insertFormulas(formulasEntity: FormulasEntity): Completable =
        formulasDao
            .insertData(formulasEntity)
            
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}