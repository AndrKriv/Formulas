package com.example.formulas.presentation.info

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.formulas.R
import com.example.formulas.app.App
import com.example.formulas.core.BaseFragment
import com.example.formulas.databinding.FragmentInfoBinding
import com.example.formulas.extension.viewBinding
import com.example.formulas.presentation.info.adapter.InfoAdapter

class InfoFragment : BaseFragment(R.layout.fragment_info) {

    private val binding: FragmentInfoBinding by viewBinding(FragmentInfoBinding::bind)

    private val infoViewModel: InfoViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as App)
            .appComponent
            .inject(this)
        setFragmentResultListener("requestKey2") { _, bundle ->
            val res = bundle.getInt("class_key")
            infoViewModel.getFormulasByClass(res)
            Log.d("AAA", res.toString())
        }
        setFragmentResultListener("requestKey") { _, bundle ->
            val themeRes = bundle.getString("theme_key")
            infoViewModel.getFormulasByTheme(themeRes.toString())
            Log.d("AAA", themeRes.toString())
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val infoAdapter = InfoAdapter()
        binding.infoRecyclerView.adapter = infoAdapter
        infoViewModel.infoLiveData.observe(viewLifecycleOwner) {
            Log.e("AAA", it[0].formula)
            infoAdapter.setItems(it)
        }
        binding.infoBackBtn.setOnClickListener {
            findNavController().popBackStack()
        }
        infoViewModel.errorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(
                requireContext(),
                "Никаких данных в этом классе пока нет",
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.infoRecyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }
}