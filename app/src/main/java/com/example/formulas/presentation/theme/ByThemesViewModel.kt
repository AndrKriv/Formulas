package com.example.formulas.presentation.theme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.formulas.core.BaseViewModel
import com.example.formulas.domain.interactor.FormulasInteractor
import javax.inject.Inject

class ByThemesViewModel @Inject constructor(
    private val formulasInteractor: FormulasInteractor
) : BaseViewModel() {

    private val _infoLiveData = MutableLiveData<List<String>>()
    val infoLiveData: LiveData<List<String>> = _infoLiveData
    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> = _errorLiveData

    fun getThemes() {
        formulasInteractor
            .getThemes()
            .subscribe({ formulas ->
                _infoLiveData.value = formulas
            }, {
                _errorLiveData.value = it.message
            })
            .addToDisposable()
    }
}