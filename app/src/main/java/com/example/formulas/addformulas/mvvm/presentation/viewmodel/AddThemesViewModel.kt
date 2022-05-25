package com.example.formulas.addformulas.mvvm.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.formulas.addformulas.mvvm.domain.AddThemesInteractor
import com.example.formulas.core.BaseViewModel
import com.example.formulas.core.SingleLiveEvent
import javax.inject.Inject

class AddThemesViewModel @Inject constructor(
    private val interactor: AddThemesInteractor
) : BaseViewModel() {

    private val _themesLiveData = MutableLiveData<String>()
    val themesLiveData: LiveData<String> = _themesLiveData
    val successLiveData = SingleLiveEvent<String>()
    val errorLiveData = SingleLiveEvent<String>()

    fun getThemes() =
        interactor
            .getThemes()
            .subscribe({ themes ->
                _themesLiveData.value = themes
            }, { throwable ->
                errorLiveData.value = throwable.message
            })
            .addToDisposable()

    fun insertTheme(theme: String) =
        interactor
            .insertTheme(theme)
            .subscribe({
                successLiveData.value = "Успешно добавлено/заменено(Replace)"
            }, { errorLiveData.value = it.message })
            .addToDisposable()

    fun removeTheme(theme: String) =
        interactor
            .removeTheme(theme)
            .subscribe({
                successLiveData.value = "Успешно удалено"
            }, { errorLiveData.value = it.message })
            .addToDisposable()
}