package com.example.formulas.addformulas.mvvm.from_that_proj

fun powF(a: String, pow: String) = "\\left({$a}^{$pow}\\right)"
fun logF(high: String, low: String) = "\\log_{$high}{$low}"
fun fracF(a: String, b: String) = "\\frac{$a}{$b}"
fun sqrtPowF(a: String, pow: String) = "\\sqrt[$pow]{$a}"
fun sinF(a: String) = "\\sin{$a}"
fun cosF(a: String) = "\\cos{$a}"
fun sqrtF(s: String) = "\\sqrt{$s}"