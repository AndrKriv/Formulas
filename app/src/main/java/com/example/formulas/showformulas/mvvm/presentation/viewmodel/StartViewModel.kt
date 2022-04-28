package com.example.formulas.showformulas.mvvm.presentation.viewmodel

import android.content.Context
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.formulas.R
import javax.inject.Inject

class StartViewModel @Inject constructor(): ViewModel() {

    private val _classNumberData = MutableLiveData<Int>()
    val classNumberData: LiveData<Int> = _classNumberData
    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> = _errorLiveData

    private fun checkClassNumber(classNumberByText: String, context: Context): Int =
        when (classNumberByText) {
            context.getString(R.string.btn_5) -> 5
            context.getString(R.string.btn_6) -> 6
            context.getString(R.string.btn_7) -> 7
            context.getString(R.string.btn_8) -> 8
            context.getString(R.string.btn_9) -> 9
            context.getString(R.string.btn_10) -> 10
            context.getString(R.string.btn_11) -> 11
            else -> 0
        }

    fun getClassNumber(classNumberByText: String, context: Context) {
        _classNumberData.value = checkClassNumber(classNumberByText, context)
    }

    fun sendNumber(fragment: Fragment, classNumberByText: String, context: Context) =
        fragment
            .setFragmentResult(
                "requestKey",
                bundleOf(
                    "key" to checkClassNumber(classNumberByText, context).toString()
                )
            )
}