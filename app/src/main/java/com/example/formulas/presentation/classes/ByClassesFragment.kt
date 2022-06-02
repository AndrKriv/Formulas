package com.example.formulas.presentation.classes

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.formulas.R
import com.example.formulas.app.App
import com.example.formulas.core.BaseFragment
import com.example.formulas.databinding.FragmentClassBinding
import com.example.formulas.extension.OnIntItemClick
import com.example.formulas.extension.changeFragment
import com.example.formulas.extension.fromStringToStartUIModelList
import com.example.formulas.extension.viewBinding
import com.example.formulas.presentation.info.InfoFragment
import com.example.formulas.presentation.classes.adapter.ClassAdapter
import com.example.formulas.presentation.start.StartFragment

class ByClassesFragment : BaseFragment(R.layout.fragment_class), OnIntItemClick {
    private val binding: FragmentClassBinding by viewBinding(FragmentClassBinding::bind)

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
        val classAdapter = ClassAdapter(this)
        binding.classRecyclerButtons.adapter = classAdapter
        classAdapter.setItems(listOfStartUIModel)
        binding.classRecyclerButtons.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        binding.classBackBtn.setOnClickListener {
            this@ByClassesFragment.changeFragment(StartFragment())
        }
    }

    override fun onElementClickListener(classNumb: Int) {
        val classNumber = classNumb + 5
        Log.e("AAA", classNumber.toString())
        setFragmentResult(
            "requestKey2",
            bundleOf(
                "key" to classNumber
            )
        )
        this@ByClassesFragment.changeFragment(InfoFragment())
    }
}