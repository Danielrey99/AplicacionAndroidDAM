package com.montecastelo.todolist.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Add
import androidx.compose.material.icons.twotone.DateRange
import androidx.compose.material.icons.twotone.Home
import androidx.compose.material.icons.twotone.Settings
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
import com.montecastelo.todolist.navigation.Navigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScreen(){

    val navController = rememberNavController()

    Scaffold(
        topBar = {
            ToDoListTopAppBar(navController = navController)
        },
        bottomBar = {
            ToDoListBottomAppBar()
        },
        floatingActionButton = {
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
    var titleText by remember { mutableStateOf("To Do List")}
    navController.addOnDestinationChangedListener { _, destination, _ ->
        titleText = when(destination.route){
            LISTAS_SCREEN_ROUTE -> "Lista"
            ADD_LISTAS_SCREEN_ROUTE -> "Add Lista"
            else -> "To Do List"
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
    modifier: Modifier = Modifier
){
    BottomAppBar(
        modifier = modifier,
        actions = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.TwoTone.Home, contentDescription = "Icon Home")
            }
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.TwoTone.DateRange, contentDescription = "Icon Calendar")
            }
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.TwoTone.Settings, contentDescription = "Icon Settings")
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