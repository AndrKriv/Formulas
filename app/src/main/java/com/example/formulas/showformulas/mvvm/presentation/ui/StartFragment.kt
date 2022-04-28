package com.example.formulas.showformulas.mvvm.presentation.ui

import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import com.example.formulas.R
import com.example.formulas.databinding.FragmentStartBinding
import com.example.formulas.showformulas.mvvm.presentation.viewmodel.StartViewModel
import com.example.formulas.viewBinding

class StartFragment : BaseFragment(R.layout.fragment_start) {
    private val binding: FragmentStartBinding by viewBinding(FragmentStartBinding::bind)

    private val startViewModel: StartViewModel by viewModels { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val resources: Resources = resources
        val myArray = resources.getStringArray(R.array.classes)
        binding.startClassesSpinner.adapter = ArrayAdapter<String>(
            requireContext(),
            R.layout.support_simple_spinner_dropdown_item,
            myArray
        )
        binding.startClassesSpinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                ""
            }

        }
    }
}

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val resources: Resources = resources
//        val myArray = resources.getStringArray(R.array.classes)
//        ArrayAdapter.createFromResource(
//            requireContext(),
//            R.array.classes,
//            android.R.layout.simple_spinner_item
//        ).also {
//                adapter ->
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            binding.startClassesSpinner.adapter = adapter
//        }
//
//
//        binding.startClassesSpinner.onItemSelectedListener =
//            object : AdapterView.OnItemSelectedListener {
//                override fun onItemSelected(
//                    parent: AdapterView<*>,
//                    view: View?,
//                    position: Int,
//                    id: Long
//                ) {
//                    startViewModel.getClassNumber(myArray[position], requireContext())
//                    startViewModel.classNumberData.observe(viewLifecycleOwner) {
//                        Log.e("AAA", it.toString())
//                    }
//                    //val classNumber = startViewModel.checkClassNumber(myArray[position],requireContext())
//                    binding.startOpenBtn.setOnClickListener {
//                        //changeFragment()
//                        this@StartFragment.changeFragment(InfoFragment())
//                        startViewModel.sendNumber(
//                            this@StartFragment,
//                            myArray[position],
//                            requireContext()
//                        )
//                    }
//                }
//
//                override fun onNothingSelected(parent: AdapterView<*>) {
//                    binding.startOpenBtn.setOnClickListener {}
//                }
//            }
//    }