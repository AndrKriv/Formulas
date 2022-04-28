package com.example.formulas.addformulas.mvvm.presentation.ui

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import com.example.formulas.R
import com.example.formulas.addformulas.mvvm.presentation.viewmodel.AddFormulasViewModel
import com.example.formulas.databinding.AddFormulasBinding
import com.example.formulas.di.app.App
import com.example.formulas.showformulas.mvvm.presentation.ui.BaseFragment
import com.example.formulas.viewBinding

class AddFormulasFragment : BaseFragment(R.layout.add_formulas) {

    private val addFormulasViewModel: AddFormulasViewModel by viewModels { viewModelFactory }

    private val binding: AddFormulasBinding by viewBinding(AddFormulasBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.addFormulasSpinnerClasses.adapter = ArrayAdapter.createFromResource(
//            requireContext(),
//            R.layout.support_simple_spinner_dropdown_item,
//            arrayListOf<Int>(5,6,7,8,9,10,11)
//        )
        binding.addFormulasSpinnerThemes

        binding.addFormulasAddBtn.setOnClickListener {

        }
        binding.addFormulasDeleteBtn.setOnClickListener {

        }
        binding.addFormulasNameOfFormula.text
//        val entity = FormulasEntity(5,"Квадрат", "x^2+y^2","Тема")
//        addFormulasViewModel.addFormulas(entity)
        //binding.addFormulasSpinnerThemes
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as App)
            .appComponent
            .inject(this)
    }
}