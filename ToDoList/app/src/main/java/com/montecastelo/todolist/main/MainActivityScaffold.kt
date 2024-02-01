package com.montecastelo.todolist.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Add
import androidx.compose.material.icons.twotone.DateRange
import androidx.compose.material.icons.twotone.Home
import androidx.compose.material.icons.twotone.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.montecastelo.todolist.data.Lista
import com.montecastelo.todolist.listas.ListasViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldWindow(){

    val viewModel: ListasViewModel = hiltViewModel()
    var state = viewModel.state

    Scaffold(
        topBar = {
            WorkoutsTopAppBar()
        },
        bottomBar = {
            WorkoutsBottomAppBar()
        },
        floatingActionButton = {

        },
    ) { paddingValues ->
        MainWindow(modifier = Modifier.padding(paddingValues), state)
    }
}


@Composable
fun MainWindow(
    modifier: Modifier = Modifier,
    state : List<Lista> = emptyList()
){
    LazyColumn(
        modifier = modifier.padding(start = 8.dp).padding(end = 8.dp),
    ){
        items(state){lista ->
            Card(modifier = Modifier.padding(top = 18.dp)) {
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkoutsTopAppBar(
    modifier: Modifier = Modifier,
){
    CenterAlignedTopAppBar(
        modifier = Modifier,
        title = { Text(text = "Home") },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Composable
fun WorkoutsBottomAppBar(
    modifier: Modifier = Modifier
){
    BottomAppBar(
        modifier = modifier,
        actions = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.TwoTone.Home, contentDescription = "Icon Home",)
            }
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.TwoTone.DateRange, contentDescription = "Icon Calendar",)
            }
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.TwoTone.Settings, contentDescription = "Icon Settings",)
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(imageVector = Icons.TwoTone.Add, contentDescription = "Icon image",)
            }
        }
    )
}