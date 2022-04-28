package com.example.formulas.showformulas.mvvm.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.formulas.fromEntityToInfoModelList
import com.example.formulas.showformulas.mvvm.core.InfoModel
import com.example.formulas.showformulas.mvvm.domain.FormulasInteractor
import com.taeim.mathdisplay.AndroidMathView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class InfoViewModel @Inject constructor(
    private val formulasInteractor: FormulasInteractor
) : BaseViewModel() {

    private val _infoLiveData = MutableLiveData<List<InfoModel>>()
    val infoLiveData: LiveData<List<InfoModel>> = _infoLiveData
    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> = _errorLiveData

    fun getFormulasData(classNumber: Int) {
        formulasInteractor
            .getFormulasByClass(classNumber)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ formulas ->
                _infoLiveData.value = formulas.fromEntityToInfoModelList()
            }, {
                _errorLiveData.value = it.message
            })
            .addToDisposable()
    }
}