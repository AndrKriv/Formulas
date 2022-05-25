package com.example.formulas.presentation.password

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.formulas.core.BaseViewModel
import javax.inject.Inject

class PasswordViewModel @Inject constructor() : BaseViewModel() {

    private val _passwordState = MutableLiveData<PasswordState>()
    val passwordState: LiveData<PasswordState> = _passwordState

    fun login(password: String) {
        _passwordState.value = PasswordState.Empty
        if (password == "1111") {
            _passwordState.value = PasswordState.Success
        } else {
            _passwordState.value = PasswordState.Error("Неверный пароль")
        }
    }

    sealed class PasswordState {
        object Success : PasswordState()
        data class Error(val message: String) : PasswordState()
        object Empty : PasswordState()
    }
}