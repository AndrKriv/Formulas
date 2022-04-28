package com.example.formulas.showformulas.mvvm.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import com.example.formulas.R
import com.example.formulas.databinding.FragmentInfoBinding
import com.example.formulas.di.app.App
import com.example.formulas.showformulas.mvvm.presentation.adapter.InfoAdapter
import com.example.formulas.showformulas.mvvm.presentation.viewmodel.InfoViewModel
import com.example.formulas.showformulas.util.changeFragment
import com.example.formulas.viewBinding
import com.taeim.mathdisplay.AndroidMathView

class InfoFragment : BaseFragment(R.layout.fragment_info) {

    private val binding: FragmentInfoBinding by viewBinding(FragmentInfoBinding::bind)

    private val infoViewModel: InfoViewModel by viewModels { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("requestKey") { _, bundle ->
            val res = bundle.getString("key")
            res?.toInt()?.let { infoViewModel.getFormulasData(it) }
            Log.d("AAA", res.toString())
        }

        val infoAdapter = InfoAdapter()
        binding.infoRecyclerView.adapter = infoAdapter
        infoViewModel.infoLiveData.observe(viewLifecycleOwner) {
            infoAdapter.setItems(it)
        }

        binding.infoBackBtn.setOnClickListener {
            this@InfoFragment.changeFragment(StartFragment())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as App).appComponent.inject(this)
    }
}