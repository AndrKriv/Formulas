package com.example.formulas.presentation.start

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.formulas.R
import com.example.formulas.app.App
import com.example.formulas.core.BaseFragment
import com.example.formulas.databinding.FragmentStartBinding
import com.example.formulas.extension.viewBinding

class StartFragment : BaseFragment(R.layout.fragment_start) {
    private val binding: FragmentStartBinding by viewBinding(FragmentStartBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as App)
            .appComponent
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.byClasses.setOnClickListener {
            findNavController().navigate(R.id.action_navigationStart_to_navigationClass)
        }
        binding.byThemes.setOnClickListener {
            findNavController().navigate(R.id.action_navigationStart_to_navigationTheme)
        }
    }
}