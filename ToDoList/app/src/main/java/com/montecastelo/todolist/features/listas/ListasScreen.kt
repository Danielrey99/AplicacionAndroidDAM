package com.montecastelo.todolist.listas

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ListasScreen(viewModel: ListasViewModel = hiltViewModel()){
    var state = viewModel.state
    ListasContent(state)
}

@Composable
fun ListasContent(state : List<Lista> = emptyList()) {
    LazyColumn{
        items(state){lista ->
            Lista(lista)
        }
    }
}

@Composable
fun Lista(lista: Lista){
    Row {
        Text(lista.name)
        Text(lista.proyecto)
        Text(lista.descripcion)
    }
}

@Preview
@Composable
fun ListScreenPreview() {
    ListasContent()
}