package com.montecastelo.todolist.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.montecastelo.todolist.features.todo.TODO_SCREEN_ROUTE
import com.montecastelo.todolist.features.todo.todoscreen
import com.montecastelo.todolist.features.addlistas.addlistascreen
import com.montecastelo.todolist.features.listas.listascreen
import com.montecastelo.todolist.room.features.addlistas.addlistascreenroom
import com.montecastelo.todolist.room.features.listas.todoscreenroom

@Composable
fun Navigation(navController: NavHostController){
    NavHost(navController = navController, startDestination = TODO_SCREEN_ROUTE){
        //SQLite
        todoscreen(navController)
        listascreen()
        addlistascreen()
        //Room
        todoscreenroom()
        addlistascreenroom()
    }
}