package com.montecastelo.todolist.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.montecastelo.todolist.features.toDo.TODO_SCREEN_ROUTE
import com.montecastelo.todolist.features.toDo.todoscreen
import com.montecastelo.todolist.features.addlistas.addlistascreen
import com.montecastelo.todolist.listas.listascreen

@Composable
fun Navigation(navController: NavHostController){
    NavHost(navController = navController, startDestination = TODO_SCREEN_ROUTE){
        todoscreen(navController)
        listascreen()
        addlistascreen()
    }
}