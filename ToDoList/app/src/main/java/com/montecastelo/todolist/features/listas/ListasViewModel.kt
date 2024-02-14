package com.montecastelo.todolist.features.listas

import androidx.lifecycle.ViewModel
import com.montecastelo.todolist.R
import com.montecastelo.todolist.data.Lista
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject


@HiltViewModel
class ListasViewModel @Inject constructor(
    private val repository: ListasRepository
) :ViewModel() {
    private var _state = MutableStateFlow<List<Lista>>(listOf())
    val state = _state

    init {
        _state.value = repository.getListas()
    }
}