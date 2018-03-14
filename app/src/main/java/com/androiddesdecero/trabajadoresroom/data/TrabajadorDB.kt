package com.androiddesdecero.trabajadoresroom.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

/**
 * Created by albertopalomarrobledo on 14/3/18.
 */
@Database(entities = arrayOf(Trabajador::class), version = 1)
abstract class TrabajadorDB: RoomDatabase() {

    abstract fun trabajadorDAO(): TrabajadorDAO

    companion object {
        private lateinit var context: Context
        private val database: TrabajadorDB by lazy(LazyThreadSafetyMode.SYNCHRONIZED){
            Room.databaseBuilder(context, TrabajadorDB::class.java, "trabajador.db")
                    .allowMainThreadQueries()
                    .build()
        }

        fun getDatabase(context: Context): TrabajadorDB{
            Companion.context = context.applicationContext
            return database
        }
    }

}