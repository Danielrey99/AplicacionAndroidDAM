package com.montecastelo.todolist.room.db

import androidx.room.Database
import androidx.room.RoomDatabase

const val DATABASE_VERSION = 1

@Database(entities = [ListaEntity::class], version = DATABASE_VERSION)
abstract class ListasDBRoom : RoomDatabase() {
    abstract fun listaDao(): ListaDao
}