package com.example.formulas.addformulas.mvvm.domain

import com.example.formulas.database.dao.ClassesDao
import com.example.formulas.database.model.ClassNumberEntity
import com.example.formulas.util.fromClassesEntityListToClassesString
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AddClassesInteractor @Inject constructor(
    private val classesDao: ClassesDao
) {
    fun getClasses(): Single<String> =
        classesDao
            .getClassNumbers()
            .map { it.fromClassesEntityListToClassesString() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}