package com.example.formulas.util

import com.example.formulas.database.model.ClassNumberEntity
import com.example.formulas.database.model.FormulasEntity
import com.example.formulas.database.model.ThemesEntity
import com.example.formulas.showformulas.mvvm.model.FormulasUIModel
import com.example.formulas.showformulas.mvvm.model.StartUIModel

fun FormulasEntity.toFormulasUIModel(): FormulasUIModel =
    FormulasUIModel(
        classNumber = classNumber,
        nameOfFormula = nameOfFormula,
        formula = formula,
        theme = themeOfFormulas,
        note = "Примечание: $noteOfFormula"
    )

fun List<FormulasEntity>.fromEntityToInfoModelList(): List<FormulasUIModel> {

    val list = mutableListOf<FormulasUIModel>()
    for (value in this) {
        list.add(value.toFormulasUIModel())
    }
    return list
}

fun List<ThemesEntity>.fromThemesEntityListToThemesString(): String {

    var themesString = ""

    for (value in this) {
        themesString = "$themesString\n${value.theme}"
    }
    return themesString
}

fun List<ClassNumberEntity>.fromClassesEntityListToClassesString(): String {

    var classesString = ""

    for (value in this) {
        classesString = "${value.classNumber}\n$classesString"
    }
    return classesString
}

fun String.toStartUIModel(): StartUIModel =
    StartUIModel(
        classNumber = this
    )

fun Array<String>.fromStringToStartUIModelList(): List<StartUIModel> {

    val list = mutableListOf<StartUIModel>()
    for (value in this) {
        list.add(value.toStartUIModel())
    }
    return list
}