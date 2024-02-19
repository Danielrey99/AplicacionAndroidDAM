package com.montecastelo.todolist.room.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

const val TABLE_NAME = "ListasRoom"

@Dao
interface ListaDao {
    @Query("SELECT * FROM $TABLE_NAME")
    fun getAll(): List<ListaEntity>

    @Insert
    fun insertAll(vararg listas: ListaEntity)

    @Delete
    fun delete(lista: ListaEntity)
}