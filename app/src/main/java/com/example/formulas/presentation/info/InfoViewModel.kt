package com.example.formulas.presentation.info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.formulas.core.BaseViewModel
import com.example.formulas.domain.interactor.FormulasInteractor
import com.example.formulas.presentation.info.model.InfoUIModel
import javax.inject.Inject

class InfoViewModel @Inject constructor(
    private val formulasInteractor: FormulasInteractor
) : BaseViewModel() {

    private val _infoLiveData = MutableLiveData<List<InfoUIModel>>()
    val infoLiveData: LiveData<List<InfoUIModel>> = _infoLiveData
    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> = _errorLiveData

    fun getFormulasByClass(classNumber: Int) {
        formulasInteractor
            .getFormulasByClass(classNumber)
            .subscribe({ formulas ->
                _infoLiveData.value = formulas
            }, {
                _errorLiveData.value = it.message
            })
            .addToDisposable()
    }

    fun getFormulasByTheme(theme: String) {
        formulasInteractor
            .getFormulasByTheme(theme)
            .subscribe({ formulas ->
                _infoLiveData.value = formulas
            }, {
                _errorLiveData.value = it.message
            })
            .addToDisposable()
    }
}