package com.montecastelo.todolist.listas

import androidx.lifecycle.ViewModel
import com.montecastelo.todolist.R
import com.montecastelo.todolist.data.Lista
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
                imageResourceId = R.drawable.pato,
                name = "Lista 1",
                proyecto = "Proyecto 1",
                descripcion = "Descripción lista proyecto 1",
            ),
            Lista(
                imageResourceId = R.drawable.pato,
                name = "Lista 2",
                proyecto = "Proyecto 2",
                descripcion = "Descripción lista proyecto 2",
            ),
            Lista(
                imageResourceId = R.drawable.pato,
                name = "Lista 3",
                proyecto = "Proyecto 3",
                descripcion = "Descripción lista proyecto 3",
            ),
            Lista(
                imageResourceId = R.drawable.pato,
                name = "Lista 4",
                proyecto = "Proyecto 4",
                descripcion = "Descripción lista proyecto 4",
            ),
            Lista(
                imageResourceId = R.drawable.pato,
                name = "Lista 5",
                proyecto = "Proyecto 5",
                descripcion = "Descripción lista proyecto 5",
            ),
            Lista(
                imageResourceId = R.drawable.pato,
                name = "Lista 6",
                proyecto = "Proyecto 6",
                descripcion = "Descripción lista proyecto 6",
            ),
            Lista(
                imageResourceId = R.drawable.pato,
                name = "Lista 7",
                proyecto = "Proyecto 7",
                descripcion = "Descripción lista proyecto 7",
            ),
            Lista(
                imageResourceId = R.drawable.pato,
                name = "Lista 8",
                proyecto = "Proyecto 8",
                descripcion = "Descripción lista proyecto 8",
            ),
        )
    }
}