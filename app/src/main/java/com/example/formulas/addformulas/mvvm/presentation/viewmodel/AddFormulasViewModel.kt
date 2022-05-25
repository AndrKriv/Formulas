package com.example.formulas.addformulas.mvvm.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.formulas.R
import com.example.formulas.addformulas.mvvm.from_that_proj.*
import com.example.formulas.data.database.model.FormulasEntity
import com.example.formulas.domain.interactor.FormulasInteractor
import com.example.formulas.core.BaseViewModel
import com.example.formulas.core.SingleLiveEvent
import com.taeim.mathdisplay.AndroidMathView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AddFormulasViewModel @Inject constructor(
    private val formulasInteractor: FormulasInteractor
) : BaseViewModel() {

    //    private val _addLiveData = MutableLiveData<List<FormulasEntity>>()
//    val addLiveData: LiveData<List<FormulasEntity>> = _addLiveData
    val successLiveData = SingleLiveEvent<FormulasEntity>()
    private val _addLiveData = MutableLiveData<FormulasEntity>()
    val addLiveData: LiveData<FormulasEntity> = _addLiveData
    private val _themesLiveData = MutableLiveData<List<String>>()
    val themesLiveData: LiveData<List<String>> = _themesLiveData
    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> = _errorLiveData

    fun getThemes() =
        formulasInteractor
            .getThemes()
            .subscribe({ themes ->
                _themesLiveData.value = themes
            }, { throwable ->
                _errorLiveData.value = throwable.message
            })
            .addToDisposable()

    fun insertFormulas(formulasEntity: FormulasEntity) =
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                formulasInteractor.insert(formulasEntity)
            }
        }

    fun removeFormula(formName: String) =
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                formulasInteractor.delete(formName)
            }
        }
//            .subscribe({ form ->
//                successLiveData.value = form
//            }, { throwable ->
//                _errorLiveData.value = throwable.message
//            })
//            .addToDisposable()

    fun formulizeFormula(selectedId: Int, high: String, low: String) =
        when (selectedId) {
            R.id.sqrt -> sqrtF(high)
            R.id.sqrtPow -> sqrtPowF(high, low)
            R.id.pow -> powF(high, low)
            R.id.log -> logF(high, low)
            R.id.frac -> fracF(high, low)
            R.id.sin -> sinF(high)
            R.id.cos -> cosF(high)
            else -> "Ничего не выбрано"
        }

    fun cleanMathViewField(mathView: AndroidMathView) {
        mathView.latex = ""
    }

}