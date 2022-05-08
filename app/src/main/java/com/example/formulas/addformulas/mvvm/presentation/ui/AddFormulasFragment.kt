package com.example.formulas.addformulas.mvvm.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.formulas.R
import com.example.formulas.addformulas.mvvm.presentation.viewmodel.AddFormulasViewModel
import com.example.formulas.databinding.AddFormulasBinding
import com.example.formulas.di.app.App
import com.example.formulas.showformulas.mvvm.presentation.ui.BaseFragment
import com.example.formulas.util.viewBinding

class AddFormulasFragment : BaseFragment(R.layout.add_formulas) {

    private val addFormulasViewModel: AddFormulasViewModel by viewModels { viewModelFactory }

    private val binding: AddFormulasBinding by viewBinding(AddFormulasBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addFormulasSpinnerThemes

        binding.addFormulasAddBtn.setOnClickListener {

        }
        binding.addFormulasDeleteBtn.setOnClickListener {

        }
        binding.addFormulasNameOfFormula.text
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as App)
            .appComponent
            .inject(this)
    }
}