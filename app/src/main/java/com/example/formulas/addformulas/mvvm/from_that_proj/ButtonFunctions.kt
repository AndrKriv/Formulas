package com.example.formulas.addformulas.mvvm.from_that_proj

import android.util.Log
import com.taeim.mathdisplay.AndroidMathView

fun addButton(
    element: AndroidMathView,
    formula: AndroidMathView,
    isChecked: Boolean,
    text: String
) {
    //функция для переноса элемента в формулу и добавления знака в формулу
    when {
        //!switch.isChecked = false = !isChecked
        //если "элемент" не пуст и выключен switch, то нажатие кнопки 'добавить' приведет к добавлению "элемента" в "формулу"
        element.latex != "" && !isChecked -> {
            Log.e("AAAA", "Element + not Checked")
            formula.latex = formula.latex + element.latex
        }
        element.latex == "" && !isChecked -> Log.e("AAA", "Element Empty, Switch off")
        formula.latex != "" && isChecked && text != "" -> {
            formula.latex = formula.latex + text
            Log.e("AAA", "Formula + checked")
        }
        formula.latex != "" && isChecked && text == "" -> {
            formula.latex = formula.latex + text
            Log.e("AAA", "EditText is NULL")
        }
        formula.latex == "" && isChecked -> Log.e("AAA", "Formula Empty, Switch on")
        else -> Log.e("AAA", "Else form")
    }
}

fun save(mathView: AndroidMathView, isChecked: Boolean) {
    //добавить проверку класса, темы и непустое поле названия формулы
    //switch.isChecked = isChecked
    when {
        mathView.latex != "" && isChecked -> "" //saveFormula(formula:AndroidMathView)
        mathView.latex == "" && isChecked -> ""
        else -> return
    }
}

fun check(
    high: String,
    low: String,
    element: AndroidMathView,
    text: String
) {
    when {
        high != "" && low != "" -> {
            if (element.latex == "") {
                use(high, low, text, element)
            } else {
                use(element.latex, low, text, element)
            }
        }
        high != "" && low == "" -> Log.e("AAAA", "(2) is null")
        high == "" && low != "" -> Log.e("AAAA", "(1) is null")
        high == "" && low == "" -> Log.e("AAAA", "Both are null")
        else -> return
    }
}

fun use(
    high: String,
    low: String,
    text: String,
    mathView: AndroidMathView
) {
    mathView.latex = when (text) {
        "log" -> logF(low, high)
        "корень" -> sqrtF(high)
        "дробь" -> fracF(high, low)
        "степень" -> powF(high, low)
        else -> ""
    }
}