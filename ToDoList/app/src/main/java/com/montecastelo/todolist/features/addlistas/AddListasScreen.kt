package com.montecastelo.todolist.features.addlistas

import android.database.sqlite.SQLiteConstraintException
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.montecastelo.todolist.data.Lista
import com.montecastelo.todolist.R

@Composable
fun AddListasScreen(viewModel: AddListasViewModel = hiltViewModel()) {
    AddListasContent(
        addLista = {
            viewModel.guardarLista(it)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddListasContent(
    addLista: (Lista) -> Unit = {},
) {
    var id by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var proyecto by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(), // Ensure Column spans full width
            horizontalAlignment = Alignment.CenterHorizontally // Horizontally center Column content
        ) {
            TextField(
                value = id,
                onValueChange = { id = it },
                label = { Text("ID") },
                modifier = Modifier.padding(top = 18.dp)
            )
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
                    addLista(Lista(id, R.drawable.pato, name, proyecto, descripcion))
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
fun AddListasScreenPreview() {
    AddListasContent()
}