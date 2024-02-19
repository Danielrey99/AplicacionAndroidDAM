package com.montecastelo.todolist.room.db

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.montecastelo.todolist.data.Lista

@Entity(tableName = "ListasRoom")
class ListaEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "imageResourceId") @DrawableRes val imageResourceId: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "proyecto") val proyecto: String,
    @ColumnInfo(name = "descripcion") val descripcion: String,
)

fun ListaEntity.toDomain() = Lista(
    id = id,
    imageResourceId = imageResourceId,
    name = name,
    proyecto = proyecto,
    descripcion = descripcion,
)