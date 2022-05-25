package com.example.formulas.utils

import com.example.formulas.R

fun loadImg(string: String): Int =
    when (string) {
        "5-ый класс" -> R.drawable.five
        "6-ой класс" -> R.drawable.six
        "7-ой класс" -> R.drawable.seven
        "8-ой класс" -> R.drawable.eight
        "9-ый класс" -> R.drawable.nine
        "10-ый класс" -> R.drawable.ten
        "11-ый класс" -> R.drawable.eleven
        else -> R.drawable.five
    }