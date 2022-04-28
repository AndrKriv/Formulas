package com.example.formulas.showformulas.mvvm.presentation.ui

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.example.formulas.ViewModelFactory
import javax.inject.Inject

abstract class BaseFragment(@LayoutRes val layoutId: Int) : Fragment(layoutId) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
}