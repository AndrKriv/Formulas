package com.example.formulas.showformulas.mvvm.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.formulas.R
import com.example.formulas.addformulas.mvvm.presentation.AddActivity
import com.example.formulas.databinding.FragmentPassBinding
import com.example.formulas.di.app.App
import com.example.formulas.showformulas.mvvm.presentation.viewmodel.PasswordViewModel
import com.example.formulas.util.viewBinding
import com.google.android.material.snackbar.Snackbar

class PasswordFragment : BaseFragment(R.layout.fragment_pass) {

    private val binding: FragmentPassBinding by viewBinding(FragmentPassBinding::bind)

    private val passwordViewModel: PasswordViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (requireContext().applicationContext as App)
            .appComponent
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        passwordViewModel.passwordState.observe(viewLifecycleOwner) {
            when (it) {
                is PasswordViewModel.PasswordState.Success -> {
                    requireActivity().run {
                        startActivity(Intent(this, AddActivity::class.java))
                        finish()
                    }
                }
                is PasswordViewModel.PasswordState.Error -> {
                    Snackbar.make(binding.root, it.message, Snackbar.LENGTH_SHORT).show()
                }
                else -> Unit
            }
        }
        binding.passButtonToActAdd.setOnClickListener {
            passwordViewModel.login(binding.textPassword.text.toString())
        }
    }
}