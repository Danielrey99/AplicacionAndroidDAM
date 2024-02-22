package com.montecastelo.todolist.features.listas

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.montecastelo.todolist.data.Lista

@Composable
fun ListasScreen(
    viewModel: ListasViewModel = hiltViewModel()
) {
    //Lista
    val state = viewModel.state.collectAsState().value.filter { it.id == 1 }
    //Api
    val catState = viewModel.catState.collectAsState().value

    //Shared preferences
    val sharedPref = LocalContext.current.getSharedPreferences("MY_APP_PREFS", Context.MODE_PRIVATE)
    if (catState != "No hay conexión a internet" && catState != "No hay datos") {
        sharedPref.edit().putString("CAT_STATE", catState).apply()
    }
    val datashared = sharedPref.getString("CAT_STATE", null) ?: "No hay datos"

    ListasContent(state, catState, datashared)
}

@Composable
fun ListasContent(
    state: List<Lista> = emptyList(),
    catState: String,
    datashared: String
) {
    Column {
        Row {
            Card(
                modifier = Modifier.padding(18.dp)
            ) {
                LazyColumn {
                    items(state) { lista ->
                        Lista(lista)
                    }
                }
            }
        }
        Card(
            modifier = Modifier.padding(18.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(textAlign = TextAlign.Center, text = "Api:")
                Text(textAlign = TextAlign.Center, text = catState)
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(textAlign = TextAlign.Center, text = "SharedPreferences")
                Text(textAlign = TextAlign.Center, text = datashared)
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(textAlign = TextAlign.Center, text = "DataStore")
            }
        }
    }
}

@Composable
fun Lista(lista: Lista) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Row {
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Image(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape),
                    painter = painterResource(lista.imageResourceId),
                    contentDescription = "Imagen"
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(18.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(textAlign = TextAlign.Center, text = lista.name)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(lista.proyecto)
        }
        Row(
            modifier = Modifier
                .padding(start = 8.dp)
        ) {
            Text(lista.descripcion)
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ListScreenPreview() {
//    ListasScreen()
//}