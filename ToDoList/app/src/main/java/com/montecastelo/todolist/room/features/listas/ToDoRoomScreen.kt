package com.montecastelo.todolist.room.features.listas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.montecastelo.todolist.data.Lista
import com.montecastelo.todolist.ui.theme.ToDoListTheme
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun ToDoRoomScreen(
    viewModel: ListasViewModelRoom = hiltViewModel()
){
    val state = viewModel.state.collectAsState()
    ToDoRoomContent(
        state = state.value,
    )
}

@Composable
fun ToDoRoomContent(
    modifier: Modifier = Modifier,
    state: List<Lista> = emptyList()
){
    LazyColumn(
        modifier = modifier
            .padding(start = 8.dp)
            .padding(end = 8.dp),
    ){
        items(state){lista ->
            Card(
                modifier = Modifier
                    .padding(top = 18.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                ){
                    Image(
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape),
                        painter = painterResource(lista.imageResourceId),
                        contentDescription = "Imagen"
                    )
                    Column(
                        modifier = Modifier.padding(start = 12.dp)
                    ) {
                        Text(text = lista.name)
                        Text(text = lista.proyecto)
                        Text(text = lista.descripcion)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ToDoRoomScreenPreview(){
    ToDoListTheme {
        ToDoRoomScreen()
    }
}