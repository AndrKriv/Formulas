package com.example.formulas.extension

import com.example.formulas.data.database.model.FormulasEntity
import com.example.formulas.data.database.model.ThemesEntity
import com.example.formulas.presentation.info.model.InfoUIModel
import com.example.formulas.presentation.start.model.ClassUIModel

fun FormulasEntity.toFormulasUIModel(): InfoUIModel =
    InfoUIModel(
        classNumber = classNumber,
        nameOfFormula = nameOfFormula,
        formula = formula,
        theme = themeOfFormulas,
        note = noteOfFormula
    )

fun ThemesEntity.themeToString(): String = this.theme

fun List<FormulasEntity>.fromEntityToInfoModelList(): List<InfoUIModel> {

    val list = mutableListOf<InfoUIModel>()
    for (value in this) {
        list.add(value.toFormulasUIModel())
    }
    return list
}

fun List<ThemesEntity>.fromThemesEntityListToStringList(): List<String> {

    val stringList = mutableListOf<String>()

    for (value in this) {
        stringList.add(value.themeToString())
    }
    return stringList
}

fun String.toStartUIModel(): ClassUIModel =
    ClassUIModel(
        classNumber = this
    )

fun Array<String>.fromStringToStartUIModelList(): List<ClassUIModel> {

    val list = mutableListOf<ClassUIModel>()
    for (value in this) {
        list.add(value.toStartUIModel())
    }
    return list
}