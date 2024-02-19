package com.montecastelo.todolist.features.addlistas

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val ADD_LISTAS_SCREEN_ROUTE = "add_listas_screen"

fun NavController.navigateToAddListasScreen() {
    navigate(ADD_LISTAS_SCREEN_ROUTE)
}

fun NavGraphBuilder.addlistascreen() {
    composable(ADD_LISTAS_SCREEN_ROUTE) { AddListasScreen() }
}