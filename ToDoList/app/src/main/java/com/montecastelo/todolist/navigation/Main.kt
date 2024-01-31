package com.montecastelo.todolist.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.montecastelo.todolist.features.addlistas.addlistascreen
import com.montecastelo.todolist.listas.ROUTE
import com.montecastelo.todolist.listas.listascreen

@Composable
fun Navigation(modifier: Modifier = Modifier){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ROUTE){
        listascreen()
        addlistascreen()
    }
}