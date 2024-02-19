package com.montecastelo.todolist.room.di

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.room.Room
import com.montecastelo.todolist.db.ToDoListDBHelper
import com.montecastelo.todolist.room.db.ListasDBRoom
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
object ListasDBModuleRoom {
    const val DATABASE_NAME = "ToDoRoom.db"

    @Provides
    fun providesListasDBRoom(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        ListasDBRoom::class.java, DATABASE_NAME
    ).build()

    @Provides
    fun providesListaDao(listasDBRoom: ListasDBRoom)= listasDBRoom.listaDao()
}