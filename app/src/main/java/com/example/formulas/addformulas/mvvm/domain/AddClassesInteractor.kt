package com.example.formulas.addformulas.mvvm.domain

import com.example.formulas.data.database.dao.ClassesDao
import com.example.formulas.extension.fromClassesEntityListToClassesString
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