package com.montecastelo.todolist.room.features.addlistas

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val ADD_LISTAS_ROOM_SCREEN_ROUTE = "add_listas_room_screen"

fun NavController.navigateToAddListasRoomScreen() {
    navigate(ADD_LISTAS_ROOM_SCREEN_ROUTE)
}

fun NavGraphBuilder.addlistascreenroom() {
    composable(ADD_LISTAS_ROOM_SCREEN_ROUTE) {
        AddListasRoomScreen()
    }
}