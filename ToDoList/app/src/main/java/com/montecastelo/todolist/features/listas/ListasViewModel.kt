package com.montecastelo.todolist.listas

import androidx.lifecycle.ViewModel
import com.montecastelo.todolist.R
import com.montecastelo.todolist.data.Lista
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject


@HiltViewModel
class ListasViewModel @Inject constructor() :ViewModel() {
    var _state = MutableStateFlow<List<Lista>>(listOf())
    val state = _state
    init {
        _state.value = listOf(
            Lista(
                id = 1,
                imageResourceId = R.drawable.pato,
                name = "Lista 1",
                proyecto = "Proyecto 1",
                descripcion = "Descripción lista proyecto 1",
            ),
            Lista(
                id = 2,
                imageResourceId = R.drawable.pato,
                name = "Lista 2",
                proyecto = "Proyecto 2",
                descripcion = "Descripción lista proyecto 2",
            ),
            Lista(
                id = 3,
                imageResourceId = R.drawable.pato,
                name = "Lista 3",
                proyecto = "Proyecto 3",
                descripcion = "Descripción lista proyecto 3",
            ),
            Lista(
                id = 4,
                imageResourceId = R.drawable.pato,
                name = "Lista 4",
                proyecto = "Proyecto 4",
                descripcion = "Descripción lista proyecto 4",
            ),
            Lista(
                id = 5,
                imageResourceId = R.drawable.pato,
                name = "Lista 5",
                proyecto = "Proyecto 5",
                descripcion = "Descripción lista proyecto 5",
            ),
            Lista(
                id = 6,
                imageResourceId = R.drawable.pato,
                name = "Lista 6",
                proyecto = "Proyecto 6",
                descripcion = "Descripción lista proyecto 6",
            ),
            Lista(
                id = 7,
                imageResourceId = R.drawable.pato,
                name = "Lista 7",
                proyecto = "Proyecto 7",
                descripcion = "Descripción lista proyecto 7",
            ),
            Lista(
                id = 8,
                imageResourceId = R.drawable.pato,
                name = "Lista 8",
                proyecto = "Proyecto 8",
                descripcion = "Descripción lista proyecto 8",
            ),
        )
    }
}