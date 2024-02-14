package com.montecastelo.todolist.features.listas

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import com.montecastelo.todolist.data.Lista
import com.montecastelo.todolist.db.ToDoBDScheme
import javax.inject.Inject

class ListasRepository @Inject constructor(
    private val writableDB: SQLiteDatabase
) {

    fun getListas(): List<Lista> {
        val cursor = writableDB.query(
            ToDoBDScheme.TABLE_NAME,
            arrayOf(
                ToDoBDScheme.COLUMN_ID,
                ToDoBDScheme.COLUMN_IMAGE,
                ToDoBDScheme.COLUMN_NAME,
                ToDoBDScheme.COLUMN_PROYECTO,
                ToDoBDScheme.COLUMN_DESCRIPCION
            ),
            null, null, null, null, null
        )
        val listas = mutableListOf<Lista>()
        with(cursor) {
            while (moveToNext()) {
                listas.add(
                    Lista(
                        id = getString(getColumnIndexOrThrow(ToDoBDScheme.COLUMN_ID)),
                        imageResourceId = getInt(getColumnIndexOrThrow(ToDoBDScheme.COLUMN_IMAGE)),
                        name = getString(getColumnIndexOrThrow(ToDoBDScheme.COLUMN_NAME)),
                        proyecto = getString(getColumnIndexOrThrow(ToDoBDScheme.COLUMN_PROYECTO)),
                        descripcion = getString(getColumnIndexOrThrow(ToDoBDScheme.COLUMN_DESCRIPCION)),
                    )
                )
            }
        }
        cursor.close()
        return listas.toList()
    }

    fun guardarLista(lista: Lista) {
        val values = ContentValues().apply {
            put(ToDoBDScheme.COLUMN_ID, lista.id)
            put(ToDoBDScheme.COLUMN_IMAGE, lista.imageResourceId)
            put(ToDoBDScheme.COLUMN_NAME, lista.name)
            put(ToDoBDScheme.COLUMN_PROYECTO, lista.proyecto)
            put(ToDoBDScheme.COLUMN_DESCRIPCION, lista.descripcion)
        }
        writableDB.insert(ToDoBDScheme.TABLE_NAME, null, values)
    }
}