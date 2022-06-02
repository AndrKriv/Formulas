package com.example.formulas.presentation.theme

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.formulas.R
import com.example.formulas.app.App
import com.example.formulas.core.BaseFragment
import com.example.formulas.databinding.FragmentThemeBinding
import com.example.formulas.extension.*
import com.example.formulas.presentation.info.InfoFragment
import com.example.formulas.presentation.start.StartFragment
import com.example.formulas.presentation.theme.adapter.ThemesAdapter

class ByThemesFragment : BaseFragment(R.layout.fragment_theme), OnStringItemClick {

    private val binding: FragmentThemeBinding by viewBinding(FragmentThemeBinding::bind)
    private val themeViewModel: ByThemesViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as App)
            .appComponent
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val themesAdapter = ThemesAdapter(this)
        binding.themeRecyclerButtons.adapter = themesAdapter
        themeViewModel.infoLiveData.observe(viewLifecycleOwner) {
            Log.e("AAA", it[0])
            themesAdapter.setItems(it)
        }
        val listOfThemes = listOf<String>()
        binding.themeRecyclerButtons.adapter = themesAdapter
        themesAdapter.setItems(listOfThemes)
        binding.themeRecyclerButtons.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        themeViewModel.errorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(
                requireContext(),
                "Никаких тем пока нет",
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.themeBackBtn.setOnClickListener {
            this@ByThemesFragment.changeFragment(StartFragment())
        }
    }

    override fun onElementClickListener(theme: String) {
        Log.e("AAA", theme)
        setFragmentResult(
            "requestKey",
            bundleOf(
                "theme_key" to theme
            )
        )
        this@ByThemesFragment.changeFragment(InfoFragment())
    }

    override fun onStart() {
        super.onStart()
        themeViewModel.getThemes()
    }
}