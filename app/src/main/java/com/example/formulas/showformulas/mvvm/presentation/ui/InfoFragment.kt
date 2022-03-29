package com.example.formulas.showformulas.mvvm.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.example.formulas.R
import com.example.formulas.databinding.FragmentInfoBinding
import com.example.formulas.showformulas.mvvm.presentation.adapter.InfoAdapter
import com.example.formulas.viewBinding

class InfoFragment : Fragment(R.layout.fragment_info) {

    private val binding: FragmentInfoBinding by viewBinding(FragmentInfoBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.infoRecyclerView.adapter = InfoAdapter()

        setFragmentResultListener("requestKey") { _, bundle ->
            val res = bundle.getString("key")
            Log.d("AAA", res.toString())
        }

        binding.infoBackBtn.setOnClickListener {
            changeFragment()
        }
    }

    private fun changeFragment() {
        fragmentManager
            ?.beginTransaction()
            ?.replace(R.id.navHostFragment, StartFragment())
            ?.addToBackStack(StartFragment().tag)
            ?.commit()
    }
}