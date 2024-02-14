package com.montecastelo.todolist.features.addlistas

import androidx.lifecycle.ViewModel
import com.montecastelo.todolist.features.listas.ListasRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddListasViewModel @Inject constructor(
    private val repository: ListasRepository
): ViewModel(){
    fun guardarLista(imageResourceId: Int, name: String, proyecto: String, descripcion: String) {
        repository.guardarLista(imageResourceId,name,proyecto,descripcion)
    }
}