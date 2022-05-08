package com.example.formulas.addformulas.mvvm.domain

import com.example.formulas.database.dao.ThemesDao
import com.example.formulas.database.model.ThemesEntity
import com.example.formulas.util.fromThemesEntityListToThemesString
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AddThemesInteractor @Inject constructor(
    private val themesDao: ThemesDao
) {
    fun getThemes(): Observable<String> =
        themesDao
            .getThemes()
            .map { it.fromThemesEntityListToThemesString() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun insertTheme(theme: String): Completable = themesDao
        .insertTheme(ThemesEntity(theme = theme))
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    fun removeTheme(theme: String): Completable =
        themesDao.removeTheme(theme)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}