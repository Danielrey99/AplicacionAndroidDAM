package com.montecastelo.todolist.room.features.listas

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.montecastelo.todolist.data.Lista
import com.montecastelo.todolist.room.repository.ListasRepositoryRoom
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ListasViewModelRoom @Inject constructor(
    private val repository: ListasRepositoryRoom
) : ViewModel() {
    private var _state = MutableStateFlow(emptyList<Lista>())
    val state: StateFlow<List<Lista>> = _state

    init {
        viewModelScope.launch() {
            withContext(Dispatchers.IO){
                _state.value = repository.getListas()
            }
        }
    }
}