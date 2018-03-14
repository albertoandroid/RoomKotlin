package com.androiddesdecero.trabajadoresroom.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by albertopalomarrobledo on 14/3/18.
 */

@Entity(tableName = "trabajadores")
class Trabajador (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,
    @ColumnInfo(name = "nombre")
    var name: String? = null,
    @ColumnInfo(name = "puesto")
    var puesto: String? = null,
    @ColumnInfo(name = "antiguedad")
    var antiguedad: String? = null){
}