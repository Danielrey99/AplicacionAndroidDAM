package com.montecastelo.todolist.features.addlistas

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

val ROUTE = "add_listas_screen"

fun NavController.navigateToAddListasScreen() {
    navigate(ROUTE)
}

fun NavGraphBuilder.addlistascreen(
){
    composable(ROUTE) { AddListasScreen() }
}