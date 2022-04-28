package com.example.formulas.showformulas.util

import androidx.fragment.app.Fragment
import com.example.formulas.R
import com.example.formulas.showformulas.mvvm.presentation.ui.InfoFragment

fun Fragment.changeFragment(fragment: Fragment){
    fragmentManager
        ?.beginTransaction()
        ?.replace(R.id.navHostFragment, fragment)
        ?.addToBackStack(fragment.tag)
        ?.commit()
}