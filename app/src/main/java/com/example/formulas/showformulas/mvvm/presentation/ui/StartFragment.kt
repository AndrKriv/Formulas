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
            binding.classesSpinner.adapter = adapter
        }

        binding.classesSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val classNumber = checkClassNumber(myArray[position])
                Log.e("AAA1",classNumber.toString())
                binding.openBtn.setOnClickListener {
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
            ?.replace(R.id.nav_host_fragment, InfoFragment())
            ?.addToBackStack(InfoFragment().tag)
            ?.commit()
    }

    fun checkClassNumber(string: String):Int = when(string){
        "5-ый класс"->5
        "6-ой класс"->6
        "7-ой класс"->7
        "8-ой класс"->8
        "9-ый класс"->9
        "10-ый класс"->10
        "11-ый класс"->11
        else -> 0
    }
}