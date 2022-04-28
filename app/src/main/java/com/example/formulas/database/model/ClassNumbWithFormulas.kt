package com.example.formulas.database.model

import androidx.room.Embedded
import androidx.room.Relation

data class ClassNumbWithFormulas(
    @Embedded val classNumber: ClassNumberEntity,
    @Relation(
        parentColumn = "class_numb",
        entityColumn = "class_number"
    )
    val playlists: List<FormulasEntity>
)

//data class ThemeWithFormulas(//пока не нужен метод; понадобится, когда будет разбиение по темам
//    @Embedded val theme: ThemesEntity,
//    @Relation(
//        parentColumn = "theme",
//        entityColumn = "theme"
//    )
//    val playlists: List<FormulasEntity>
//)