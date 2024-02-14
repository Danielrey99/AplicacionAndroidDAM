package com.montecastelo.todolist.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ToDoListDBHelper(contex: Context) : SQLiteOpenHelper(contex, DATABASE_NAME, null, DATABASE_VERSION){
    override fun onCreate(bd: SQLiteDatabase) {
        bd.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(bd: SQLiteDatabase?, p1: Int, p2: Int) {
    }

    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "ToDoList.db"
    }
}