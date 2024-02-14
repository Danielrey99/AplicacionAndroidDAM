package com.montecastelo.todolist.db

import android.provider.BaseColumns

object ToDoBDScheme: BaseColumns {
    const val TABLE_NAME = "listas"
    const val COLUMN_ID = "id"
    const val COLUMN_IMAGE = "imageResourceId"
    const val COLUMN_NAME = "name"
    const val COLUMN_PROYECTO = "proyecto"
    const val COLUMN_DESCRIPCION = "descripcion"
}

const val SQL_CREATE_ENTRIES = """
    CREATE TABLE ${ToDoBDScheme.TABLE_NAME} (
    ${ToDoBDScheme.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT,
    ${ToDoBDScheme.COLUMN_IMAGE} INTEGER,
    ${ToDoBDScheme.COLUMN_NAME} TEXT,
    ${ToDoBDScheme.COLUMN_PROYECTO} TEXT,
    ${ToDoBDScheme.COLUMN_DESCRIPCION} TEXT
    )
"""

const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${ToDoBDScheme.TABLE_NAME}"