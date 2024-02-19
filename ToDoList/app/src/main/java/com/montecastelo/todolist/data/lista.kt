package com.montecastelo.todolist.data

import androidx.annotation.DrawableRes
import com.montecastelo.todolist.room.db.ListaEntity

data class Lista(
    val id: Int,
    @DrawableRes val imageResourceId: Int,
    val name: String,
    val proyecto: String,
    val descripcion: String,
)

fun Lista.toEntity() = ListaEntity(
    id = id,
    imageResourceId = imageResourceId,
    name = name,
    proyecto = proyecto,
    descripcion = descripcion,
)