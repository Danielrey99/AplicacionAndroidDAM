package com.montecastelo.todolist.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Add
import androidx.compose.material.icons.twotone.Home
import androidx.compose.material.icons.twotone.List
import androidx.compose.material3.BottomAppBar
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.montecastelo.todolist.features.addlistas.ADD_LISTAS_SCREEN_ROUTE
import com.montecastelo.todolist.features.addlistas.navigateToAddListasScreen
import com.montecastelo.todolist.features.listas.LISTAS_SCREEN_ROUTE
import com.montecastelo.todolist.features.todo.navigateToToDoScreen
import com.montecastelo.todolist.navigation.Navigation
import com.montecastelo.todolist.room.features.addlistas.ADD_LISTAS_ROOM_SCREEN_ROUTE
import com.montecastelo.todolist.room.features.addlistas.navigateToAddListasRoomScreen
import com.montecastelo.todolist.room.features.listas.TODO_ROOM_SCREEN_ROUTE
import com.montecastelo.todolist.room.features.listas.navigateToToDoRoomScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScreen(){

    val navController = rememberNavController()

    Scaffold(
        topBar = {
            // Cambiamos el titulo para cada ruta
            ToDoListTopAppBar(navController = navController)
        },
        bottomBar = {
            // Cambiamos de vista con los iconos
            ToDoListBottomAppBar(navController = navController)
        },
        floatingActionButton = {
            // Accedemos a AddLista con SQLite
            ToDoListFloatingActionButton(navController)
        },
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)){
            Navigation(navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoListTopAppBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
){
    var titleText by remember { mutableStateOf("To Do List SQLite")}
    navController.addOnDestinationChangedListener { _, destination, _ ->
        titleText = when(destination.route){
            LISTAS_SCREEN_ROUTE -> "Lista SQLite"
            ADD_LISTAS_SCREEN_ROUTE -> "Add Lista SQLite"
            TODO_ROOM_SCREEN_ROUTE -> "To Do List Room"
            ADD_LISTAS_ROOM_SCREEN_ROUTE -> "Add Lista Room"
            else -> "To Do List SQLite"
        }
    }
    CenterAlignedTopAppBar(
        modifier = Modifier,
        title = { Text(text = titleText) },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Composable
fun ToDoListBottomAppBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
){
    BottomAppBar(
        modifier = modifier,
        actions = {
            IconButton(onClick = {
                navController.navigateToToDoScreen()
            }) {
                Icon(imageVector = Icons.TwoTone.Home, contentDescription = "Icon Home")
            }
            IconButton(onClick = {
                navController.navigateToToDoRoomScreen()
            }) {
                Icon(imageVector = Icons.TwoTone.List, contentDescription = "Icon Settings")
            }
            IconButton(onClick = {
                navController.navigateToAddListasRoomScreen()
            }) {
                Icon(imageVector = Icons.TwoTone.Add, contentDescription = "Icon Settings")
            }
        },
    )
}

@Composable
fun ToDoListFloatingActionButton(
    navController: NavController,
){
    FloatingActionButton(onClick = {
        navController.navigateToAddListasScreen()
    }) {
        Icon(imageVector = Icons.TwoTone.Add, contentDescription = "Icon image")
    }
}