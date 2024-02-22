package com.montecastelo.todolist.features.listas

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.montecastelo.todolist.data.Lista
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ListasViewModel @Inject constructor(
    private val repository: ListasRepository
) : ViewModel() {
    private var _state = MutableStateFlow<List<Lista>>(listOf())
    val state = _state

    //Api
    private var _catState = MutableStateFlow("No hay datos")
    val catState = _catState

    init {
        _state.value = repository.getListas()
        //Api
        viewModelScope.launch {
            try {
                _catState.value = repository.getCatsFacts()
            }
            catch (e: Exception){
                _catState.value = "No hay conexión a internet"
            }
        }
    }
}