package com.montecastelo.todolist.room.features.addlistas

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.montecastelo.todolist.R
import com.montecastelo.todolist.room.db.ListaEntity

@Composable
fun AddListasRoomScreen(viewmodel: AddListasViewModelRoom = hiltViewModel()){
    var showDialog by remember { mutableStateOf(false) }
    AddListasRoomContent(
        addLista = {lista: ListaEntity ->
            viewmodel.guardarLista(lista)
            showDialog = true
        }
    )

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Lista añadida") },
            text = { Text("¡La lista se ha añadido correctamente!") },
            confirmButton = { Button(onClick = { showDialog = false }) { Text("OK") } }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddListasRoomContent(
    addLista: (ListaEntity) -> Unit,
){
    var name by remember { mutableStateOf("") }
    var proyecto by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier.fillMaxWidth(), // Ensure Column spans full width
            horizontalAlignment = Alignment.CenterHorizontally // Horizontally center Column content
        ) {
            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                modifier = Modifier.padding(top = 18.dp)
            )
            TextField(
                value = proyecto,
                onValueChange = { proyecto = it },
                label = { Text("Proyecto") },
                modifier = Modifier.padding(top = 18.dp)
            )
            TextField(
                value = descripcion,
                onValueChange = { descripcion = it },
                label = { Text("Descripción") },
                modifier = Modifier.padding(top = 18.dp)
            )
            Button(
                onClick = {
                    val listaEntity = ListaEntity(
                        imageResourceId = R.drawable.pato,
                        name = name,
                        proyecto = proyecto,
                        descripcion = descripcion
                    )
                    addLista(listaEntity)
                    // Reset all text fields
                    name = ""
                    proyecto = ""
                    descripcion = ""
                },
                modifier = Modifier.padding(top = 18.dp, bottom = 8.dp),

                ) {
                Text(text = "Añadir Lista")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddListasRoomScreenPreview() {
    AddListasRoomContent(
        addLista = { _ -> /* Do nothing for preview */ } // Mock implementation
    )
}