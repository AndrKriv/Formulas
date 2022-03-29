package com.example.formulas.showformulas.mvvm.presentation.ui

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.example.formulas.R
import com.example.formulas.databinding.FragmentStartBinding
import com.example.formulas.viewBinding

class StartFragment : Fragment(R.layout.fragment_start){
    private val binding: FragmentStartBinding by viewBinding(FragmentStartBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val res: Resources = resources
        val myArray = res.getStringArray(R.array.classes)
        super.onViewCreated(view, savedInstanceState)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.classes,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.startClassesSpinner.adapter = adapter
        }

        binding.startClassesSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val classNumber = checkClassNumber(myArray[position])
                Log.e("AAA1",classNumber.toString())
                binding.startOpenBtn.setOnClickListener {
                    changeFragment()
                    sendNumber(classNumber)
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    private fun sendNumber(number: Int) {
        setFragmentResult("requestKey", bundleOf("key" to number.toString()))
    }

    private fun changeFragment(){
        fragmentManager
            ?.beginTransaction()
            ?.replace(R.id.navHostFragment, InfoFragment())
            ?.addToBackStack(InfoFragment().tag)
            ?.commit()
    }

    fun checkClassNumber(string: String):Int = when(string){
        getString(R.string.btn_5)->5
        getString(R.string.btn_6)->6
        getString(R.string.btn_7)->7
        getString(R.string.btn_8)->8
        getString(R.string.btn_9)->9
        getString(R.string.btn_10)->10
        getString(R.string.btn_11)->11
        else -> 0
    }
}