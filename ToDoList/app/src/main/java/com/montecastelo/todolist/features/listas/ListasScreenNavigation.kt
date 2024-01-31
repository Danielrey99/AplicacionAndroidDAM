package com.montecastelo.todolist.listas

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

val ROUTE = "listas_screen"

fun NavController.navigateToListasScreen() {
    navigate(ROUTE)
}

fun NavGraphBuilder.listascreen(
){
    composable(ROUTE) { ListasScreen() }
}