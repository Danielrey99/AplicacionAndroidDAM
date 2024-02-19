package com.montecastelo.todolist.room.features.listas

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val TODO_ROOM_SCREEN_ROUTE = "ToDo_Room_screen"

fun NavController.navigateToToDoRoomScreen() {
    navigate(TODO_ROOM_SCREEN_ROUTE)
}

fun NavGraphBuilder.todoscreenroom() {
    composable(TODO_ROOM_SCREEN_ROUTE) {
        ToDoRoomScreen()
    }
}