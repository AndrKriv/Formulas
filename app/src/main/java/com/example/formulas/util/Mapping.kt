package com.example.formulas

import com.example.formulas.addformulas.model.FormulasUIModel
import com.example.formulas.database.model.ClassNumberEntity
import com.example.formulas.database.model.FormulasEntity
import com.example.formulas.database.model.ThemesEntity
import com.example.formulas.showformulas.mvvm.core.InfoModel

fun FormulasEntity.fromEntityToInfoModel(): InfoModel {
    return InfoModel(
        nameOfFormula = nameOf,
        formula = formula,
        classNumber = classNumber
    )
}

fun List<FormulasEntity>.fromEntityToInfoModelList(): List<InfoModel> {

    val list = mutableListOf<InfoModel>()
    for (value in this) {
        list.add(value.fromEntityToInfoModel())
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

fun FormulasUIModel.toFormulasEntity(): FormulasEntity =
    FormulasEntity(
        classNumber = classNumber,
        nameOf = nameOf,
        formula = formula,
        theme = theme
    )

fun FormulasEntity.toFormulasUIModel(): FormulasUIModel =
    FormulasUIModel(
        classNumber = classNumber,
        nameOf = nameOf,
        formula = formula,
        theme = theme
    )