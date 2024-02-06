package com.montecastelo.todolist.features.toDo

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.montecastelo.todolist.data.Lista
import com.montecastelo.todolist.listas.ListasViewModel
import com.montecastelo.todolist.ui.theme.ToDoListTheme
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun ToDoScreen(
    navigateToListasScreen: () -> Unit,
    //navigateToAddListasScreen: () -> Unit,
    viewModel: ListasViewModel = hiltViewModel()
){
    val state = viewModel.state
    ToDoContent(
        state = state,
        navigateToListasScreen = navigateToListasScreen,
        //navigateToAddListasScreen = navigateToAddListasScreen,
    )
}

@Composable
fun ToDoContent(
    modifier: Modifier = Modifier,
    navigateToListasScreen: () -> Unit,
    //navigateToAddListasScreen: () -> Unit,
    state: MutableStateFlow<List<Lista>>
){
    LazyColumn(
        modifier = modifier
            .padding(start = 8.dp)
            .padding(end = 8.dp),
    ){
        items(state.value){lista ->
            Card(
                modifier = Modifier
                    .padding(top = 18.dp)
                    .clickable(onClick = navigateToListasScreen)
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
fun ToDoScreenPreview(){
    ToDoListTheme {
        ToDoScreen(
            navigateToListasScreen = {},
            //navigateToAddListasScreen = {},
        )
    }
}