package com.androiddesdecero.trabajadoresroom.data

import android.arch.persistence.room.*

/**
 * Created by albertopalomarrobledo on 14/3/18.
 */
@Dao
interface TrabajadorDAO {

    @Insert
    fun insertTrabajador(trabajador: Trabajador)

    @Query("SELECT * FROM trabajadores WHERE nombre =:arg0")
    fun getWorkerByName(name: String): Trabajador

    @Query("SELECT * FROM trabajadores")
    fun getAllWorkers(): List<Trabajador>

    @Query("DELETE FROM trabajadores")
    fun deleteAllWorkers()

    @Delete
    fun deleteWorker(trabajador: Trabajador)

    @Update
    fun updateWorker(trabajador: Trabajador)

}