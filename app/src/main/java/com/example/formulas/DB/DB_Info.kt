package com.example.formulas.DB

import android.provider.BaseColumns

object DB_Info{
    const val TABLE_NAME = "formulas"
    const val NUMB_CLASS = "NumberOfClass"
    const val NAME_OF_FORM = "NameOfForm"
    const val FORM = "Formula"

    const val DB_NAME = "FormDB"
    const val DB_VERSION = 2

    const val SQL_CREATE_ENTRIES = "CREATE TABLE IF NOT EXISTS $TABLE_NAME " +
        "(${BaseColumns._ID} int PRIMARY KEY, $NUMB_CLASS int, $NAME_OF_FORM TEXT, $FORM TEXT, " +
           "CONSTRAINT CHK_Class CHECK ($NUMB_CLASS BETWEEN 5 AND 11)" + ")"
    const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
    const val SELECT_CLASS = "SELECT $NUMB_CLASS FROM $TABLE_NAME"
    const val SELECT_NAME_OF_FORM_TABLE = "SELECT $NAME_OF_FORM FROM $TABLE_NAME"
    const val SELECT_FORM_TABLE = "SELECT $FORM FROM $TABLE_NAME"
    const val SELECT_ALL_TABLE = "SELECT * FROM $TABLE_NAME"
}