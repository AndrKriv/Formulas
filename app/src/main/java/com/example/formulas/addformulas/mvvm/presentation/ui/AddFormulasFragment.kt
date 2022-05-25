package com.example.formulas.addformulas.mvvm.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.fragment.app.viewModels
import com.example.formulas.R
import com.example.formulas.addformulas.mvvm.from_that_proj.*
import com.example.formulas.addformulas.mvvm.presentation.viewmodel.AddFormulasViewModel
import com.example.formulas.data.database.model.FormulasEntity
import com.example.formulas.databinding.AddDataBinding
import com.example.formulas.app.App
import com.example.formulas.core.BaseFragment
import com.example.formulas.extension.viewBinding
import com.taeim.mathdisplay.AndroidMathView

class AddFormulasFragment : BaseFragment(R.layout.add_data) {

    private val addFormulasViewModel: AddFormulasViewModel by viewModels { viewModelFactory }

    // private val binding: AddFormulaBinding by viewBinding(AddFormulaBinding::bind)
    private val binding: AddDataBinding by viewBinding(AddDataBinding::bind)

    var theme = ""
    var formula = ""
    var classes: Int = 0
    lateinit var et: EditText

    lateinit var formulasEntity: FormulasEntity

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.formulaMathViewFormula.also { formulas ->
            binding.frac.run {
                latex = fracF("a", "b")
                setOnClickListener {
                    formulas.latex = fracF("a", "b")
                }
            }
            binding.log.run {
                latex = logF("a", "b")
                setOnClickListener {
                    formulas.latex = logF("a", "b")
                }
            }
            binding.sin.run {
                latex = sinF("a")
                setOnClickListener {
                    formulas.latex = sinF("a")
                }
            }
            binding.pow.run {
                latex = powF("a", "b")
                setOnClickListener {
                    formulas.latex = powF("a", "b")
                }
            }
            binding.sqrtPow.run {
                latex = sqrtPowF("a", "b")
                setOnClickListener {
                    formulas.latex = sqrtPowF("a", "b")
                }
            }
            binding.sqrt.run {
                latex = sqrtF("a")
                setOnClickListener {
                    formulas.latex = sqrtF("a")
                }
            }
        }
        val classNumbers = resources.getStringArray(R.array.classes)
        ///binding.methods.setOnCheckedChangeListener { _, selectedId ->
//            binding.formulaMathViewElement.latex =
//                addFormulasViewModel.formulizeFormula(
//                    selectedId,
//                    binding.formulaHighText.text.toString(),
//                    binding.formulaLowText.text.toString()
//                )
        //}
        addFormulasViewModel.themesLiveData.observe(viewLifecycleOwner) {
            val themesAdapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_dropdown_item,
                it
            )
            binding.formulaThemesSpinner.adapter = themesAdapter
            binding.formulaThemesSpinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    theme = it[position]
                    Log.e("AAA", it[position])
                    Log.e("AAA", "Theme: ${binding.formulaThemesSpinner.selectedItem}")
                }

                override fun onNothingSelected(parent: AdapterView<*>) {}
            }
        }
        val classesAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            classNumbers
        )
        binding.formulaClassesSpinner.adapter = classesAdapter
        binding.formulaClassesSpinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                classes = position + 5
                Log.e("AAA", classNumbers[position])
                Log.e("AAA", "Class: ${binding.formulaClassesSpinner.selectedItem}")
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
//        binding.formulaCleanMathViewFormula.setOnClickListener {
//            addFormulasViewModel.removeFormula(binding.etNameOfFormula.text.toString())
//        }
//        binding.saveFormulasDataToDB.setOnClickListener {
//            formulasEntity = FormulasEntity(
//                binding.formulaMathViewElement.latex,
//                binding.etNameOfFormula.text.toString(),
//                classes,
//                theme,
//                binding.note.text.toString()
//            )
//            addFormulasViewModel.insertFormulas(formulasEntity)
//        }
//        binding.formulaMathViewElement.latex =
//            "${sqrtF(powF("a","2"))}+${fracF("b", powF("c","2"))}=${powF(cosF("d"),"3")}*${sqrtPowF(fracF("x","y"),"5")}"
        binding.formulaMathViewFormula.labelMode =
            AndroidMathView.MTMathViewMode.KMTMathViewModeDisplay
        binding.formulaMathViewFormula
        et.text
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as App)
            .appComponent
            .inject(this)
        addFormulasViewModel.getThemes()
    }
}