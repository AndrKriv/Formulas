package com.example.formulas.showformulas.mvvm.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.formulas.showformulas.mvvm.model.FormulasUIModel
import com.example.formulas.showformulas.mvvm.domain.FormulasInteractor
import javax.inject.Inject

class InfoViewModel @Inject constructor(
    private val formulasInteractor: FormulasInteractor
) : BaseViewModel() {

    private val _infoLiveData = MutableLiveData<List<FormulasUIModel>>()
    val infoLiveData: LiveData<List<FormulasUIModel>> = _infoLiveData
    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> = _errorLiveData

    fun getFormulasData(classNumber: Int) {
        formulasInteractor
            .getFormulasByClass(classNumber)
            .subscribe({ formulas ->
                _infoLiveData.value = formulas
            }, {
                _errorLiveData.value = it.message
            })
            .addToDisposable()
    }
}