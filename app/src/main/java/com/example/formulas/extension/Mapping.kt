package com.example.formulas.extension

import com.example.formulas.data.database.model.ClassNumberEntity
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
        note = "Примечание: $noteOfFormula"
    )

fun ThemesEntity.themeToString(): String = this.theme

fun List<FormulasEntity>.fromEntityToInfoModelList(): List<InfoUIModel> {

    val list = mutableListOf<InfoUIModel>()
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

fun List<ThemesEntity>.fromThemesEntityListToStringList(): List<String> {

    var stringList = mutableListOf<String>()

    for (value in this) {
        stringList.add(value.themeToString())
    }
    return stringList
}

fun List<ClassNumberEntity>.fromClassesEntityListToClassesString(): String {

    var classesString = ""

    for (value in this) {
        classesString = "${value.classNumber}\n$classesString"
    }
    return classesString
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