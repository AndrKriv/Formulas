package com.example.formulas.addformulas.mvvm.domain

import com.example.formulas.database.dao.ClassesDao
import com.example.formulas.database.model.ClassNumberEntity
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AddClassesInteractor @Inject constructor(
    private val classesDao: ClassesDao
) {
    fun getClasses(): Observable<List<ClassNumberEntity>> =
        classesDao
            .getClassNumbers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun insertClass(classNumb: Int): Completable =
        classesDao
            .insertClassNumb(ClassNumberEntity(classNumb))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun removeClass(classNumb: Int): Completable =
        classesDao
            .removeClassNumber(classNumb)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}