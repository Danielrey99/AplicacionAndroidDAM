package com.montecastelo.todolist.room.features.addlistas

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.montecastelo.todolist.data.Lista
import com.montecastelo.todolist.room.repository.ListasRepositoryRoom
import com.montecastelo.todolist.room.db.ListaEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AddListasViewModelRoom @Inject constructor(
    private val repository: ListasRepositoryRoom
) :ViewModel() {
    private var _state = MutableStateFlow<List<Lista>>(listOf())
    val state = _state

    fun guardarLista(lista: ListaEntity) {
        viewModelScope.launch() {
            withContext(Dispatchers.IO){
                repository.guardarLista(lista)
            }
        }
    }
}