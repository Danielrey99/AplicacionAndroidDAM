package com.montecastelo.todolist.listas

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ListasViewModel @Inject constructor() :ViewModel() {
    var _state: List<Lista> = emptyList()
    val state
        get() = _state
    init {
        _state = listOf(
            Lista(
                name = "Lista 1",
                proyecto = "Proyecto 1",
                descripcion = "Descripción lista proyecto 1",
            ),
            Lista(
                name = "Lista 2",
                proyecto = "Proyecto 2",
                descripcion = "Descripción lista proyecto 2",
            ),
        )
    }
}

data class Lista(
    val name: String,
    val proyecto: String,
    val descripcion: String,
)