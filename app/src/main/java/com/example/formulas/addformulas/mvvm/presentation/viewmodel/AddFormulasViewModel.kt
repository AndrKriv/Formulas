package com.example.formulas.addformulas.mvvm.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.formulas.database.model.FormulasEntity
import com.example.formulas.showformulas.mvvm.core.InfoModel
import com.example.formulas.showformulas.mvvm.domain.FormulasInteractor
import com.example.formulas.showformulas.mvvm.presentation.viewmodel.BaseViewModel
import io.reactivex.Completable
import javax.inject.Inject

class AddFormulasViewModel @Inject constructor(
    private val formulasInteractor: FormulasInteractor
) : BaseViewModel() {

    private val _addLiveData = MutableLiveData<List<FormulasEntity>>()
    val addLiveData: LiveData<List<FormulasEntity>> = _addLiveData
    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> = _errorLiveData

//    fun addFormulas(formulasEntity: FormulasEntity){
//        Completable.create {
//            formulasInteractor
//                .insertData(formulasEntity)
//            it.onComplete()
//        }
//    }
}