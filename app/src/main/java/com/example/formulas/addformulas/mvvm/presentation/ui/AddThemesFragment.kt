package com.example.formulas.addformulas.mvvm.presentation.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.formulas.R
import com.example.formulas.addformulas.mvvm.presentation.viewmodel.AddThemesViewModel
import com.example.formulas.databinding.AddThemesBinding
import com.example.formulas.di.app.App
import com.example.formulas.showformulas.mvvm.presentation.ui.BaseFragment
import com.example.formulas.util.viewBinding

class AddThemesFragment : BaseFragment(R.layout.add_themes) {

    private val binding: AddThemesBinding by viewBinding(AddThemesBinding::bind)

    private val addThemesViewModel: AddThemesViewModel by viewModels { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addThemesAddBtn.setOnClickListener {
            addThemesViewModel.insertTheme(binding.addThemesNameOfTheme.text.toString())
        }
        binding.addThemesDeleteBtn.setOnClickListener {
            addThemesViewModel.removeTheme(binding.addThemesNameOfTheme.text.toString())
        }
        addThemesViewModel.themesLiveData.observe(viewLifecycleOwner) {
            binding.addThemesShowThemesOfFormula.text = it
        }

        addThemesViewModel.successLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
        addThemesViewModel.errorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as App)
            .appComponent
            .inject(this)
    }

    override fun onStart() {
        super.onStart()
        addThemesViewModel.getThemes()
    }
}