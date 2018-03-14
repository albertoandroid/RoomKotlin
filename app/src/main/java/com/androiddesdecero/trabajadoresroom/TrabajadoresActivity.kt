package com.androiddesdecero.trabajadoresroom

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.androiddesdecero.trabajadoresroom.R
import com.androiddesdecero.trabajadoresroom.data.Trabajador
import com.androiddesdecero.trabajadoresroom.data.TrabajadorDB
import kotlinx.android.synthetic.main.activity_trabajadores.*

class TrabajadoresActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trabajadores)

        var trabajadores: List<Trabajador> = TrabajadorDB.getDatabase(applicationContext).trabajadorDAO().getAllWorkers()

        taRv.layoutManager = LinearLayoutManager(this)
        taRv.adapter = TrabajadorAdapter(trabajadores, this)

    }
}
