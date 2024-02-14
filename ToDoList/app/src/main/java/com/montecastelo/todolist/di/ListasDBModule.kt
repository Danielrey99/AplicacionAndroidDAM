package com.montecastelo.todolist.di

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.montecastelo.todolist.db.ToDoListDBHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
object ListasDBModule {
    @Provides
    fun providesListasDBHelper(@ApplicationContext context: Context): SQLiteDatabase {
        return ToDoListDBHelper(context).writableDatabase
    }
}