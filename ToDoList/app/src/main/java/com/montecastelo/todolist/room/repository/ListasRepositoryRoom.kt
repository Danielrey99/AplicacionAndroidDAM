package com.montecastelo.todolist.room.repository

import com.montecastelo.todolist.data.Lista
import com.montecastelo.todolist.room.db.ListaDao
import com.montecastelo.todolist.room.db.ListaEntity
import com.montecastelo.todolist.room.db.toDomain
import javax.inject.Inject

class ListasRepositoryRoom @Inject constructor(
    private val listaDao: ListaDao
) {

    fun getListas(): List<Lista> = listaDao.getAll().map { it.toDomain() }

    fun guardarLista(lista: ListaEntity) = listaDao.insertAll(lista)
}