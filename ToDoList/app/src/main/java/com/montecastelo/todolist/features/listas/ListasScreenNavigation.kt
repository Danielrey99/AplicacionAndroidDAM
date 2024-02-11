package com.montecastelo.todolist.features.listas

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val LISTAS_SCREEN_ROUTE = "listas_screen"

fun NavController.navigateToListasScreen() {
    navigate(LISTAS_SCREEN_ROUTE)
}

fun NavGraphBuilder.listascreen(){
    composable(LISTAS_SCREEN_ROUTE) { ListasScreen(

    ) }
}