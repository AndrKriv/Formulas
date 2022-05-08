package com.example.formulas.showformulas.mvvm.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.formulas.R
import com.example.formulas.databinding.FragmentStartBinding
import com.example.formulas.di.app.App
import com.example.formulas.showformulas.OnItemClick
import com.example.formulas.showformulas.mvvm.presentation.adapter.StartAdapter
import com.example.formulas.showformulas.util.changeFragment
import com.example.formulas.util.fromStringToStartUIModelList
import com.example.formulas.util.viewBinding

class StartFragment : BaseFragment(R.layout.fragment_start), OnItemClick {
    private val binding: FragmentStartBinding by viewBinding(FragmentStartBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as App)
            .appComponent
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listOfString = resources.getStringArray(R.array.classes)
        val listOfStartUIModel = listOfString.fromStringToStartUIModelList()
        val startAdapter = StartAdapter(this)
        binding.startRecyclerButtons.adapter = startAdapter
        startAdapter.setItems(listOfStartUIModel)
        binding.startRecyclerButtons.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        binding.startFABAddFormula.setOnClickListener {
            Log.e("AAA", "fab is clicked")
            this@StartFragment.changeFragment(PasswordFragment())
        }
    }

    override fun onClassClickListener(classNumber: Int) {
        val classNumb = classNumber + 5
        Log.e("AAA", classNumb.toString())
        setFragmentResult(
            "requestKey",
            bundleOf(
                "key" to classNumb
            )
        )
        this@StartFragment.changeFragment(InfoFragment())
    }
}