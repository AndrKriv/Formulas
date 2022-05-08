package com.example.formulas.showformulas.mvvm.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.formulas.R
import com.example.formulas.databinding.FragmentInfoBinding
import com.example.formulas.di.app.App
import com.example.formulas.showformulas.mvvm.presentation.adapter.InfoAdapter
import com.example.formulas.showformulas.mvvm.presentation.viewmodel.InfoViewModel
import com.example.formulas.showformulas.util.changeFragment
import com.example.formulas.util.viewBinding

class InfoFragment : BaseFragment(R.layout.fragment_info) {

    private val binding: FragmentInfoBinding by viewBinding(FragmentInfoBinding::bind)

    private val infoViewModel: InfoViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as App)
            .appComponent
            .inject(this)

        setFragmentResultListener("requestKey") { _, bundle ->
            val res = bundle.getInt("key")
                infoViewModel.getFormulasData(res)
            Log.d("AAA", res.toString())
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val infoAdapter = InfoAdapter()
        binding.infoRecyclerView.adapter = infoAdapter
        infoViewModel.infoLiveData.observe(viewLifecycleOwner) {
            Log.e("AAA",it[0].formula)
            infoAdapter.setItems(it)
        }

        binding.infoBackBtn.setOnClickListener {
            this@InfoFragment.changeFragment(StartFragment())
        }
        infoViewModel.errorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "Никаких данных в этом классе пока нет", Toast.LENGTH_SHORT).show()
        }
        binding.infoRecyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }

}