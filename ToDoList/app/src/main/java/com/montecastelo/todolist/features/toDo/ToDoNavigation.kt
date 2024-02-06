package com.montecastelo.todolist.features.toDo

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.montecastelo.todolist.listas.navigateToListasScreen

const val TODO_SCREEN_ROUTE = "ToDo_screen"

fun NavController.navigateToToDoScreen() {
    navigate(TODO_SCREEN_ROUTE)
}

fun NavGraphBuilder.todoscreen(
    navController: NavHostController,
) {
    composable(TODO_SCREEN_ROUTE) { ToDoScreen(
        navigateToListasScreen = {navController.navigateToListasScreen()},
        //navigateToAddListasScreen = {navController.navigateToAddListasScreen()},
    ) }
}