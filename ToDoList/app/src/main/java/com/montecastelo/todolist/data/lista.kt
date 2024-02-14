package com.montecastelo.todolist.data

import androidx.annotation.DrawableRes

data class Lista(
    val id: String,
    @DrawableRes val imageResourceId: Int,
    val name: String,
    val proyecto: String,
    val descripcion: String,
)