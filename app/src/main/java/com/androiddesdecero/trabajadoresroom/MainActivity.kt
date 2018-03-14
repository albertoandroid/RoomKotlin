package com.androiddesdecero.trabajadoresroom

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androiddesdecero.trabajadoresroom.data.Trabajador
import com.androiddesdecero.trabajadoresroom.data.TrabajadorDB
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        maBtInsertarTrabajador.setOnClickListener({
            val intent = Intent(applicationContext, InsertEditActivity::class.java)
            intent.putExtra(Constants.NUEVO_USER, Constants.SI)
            startActivity(intent)
        })

        maBtTodosTrabajadores.setOnClickListener({
            val intent = Intent(applicationContext, TrabajadoresActivity::class.java)
            startActivity(intent)
        })

        maBtBorrarTodos.setOnClickListener({
            TrabajadorDB.getDatabase(applicationContext).trabajadorDAO().deleteAllWorkers()
        })

        maBtBuscarNombre.setOnClickListener({
            var nombre = maEtBuscar.text.toString()
            var trabajador = TrabajadorDB.getDatabase(applicationContext).trabajadorDAO().getWorkerByName(nombre)
            if(trabajador == null){
                maEtBuscar.setText("No Trabajador")
            }else{
                val intent = Intent(applicationContext, InsertEditActivity::class.java)
                intent.putExtra(Constants.ID, trabajador.id)
                intent.putExtra(Constants.NOMBRE, trabajador.name)
                intent.putExtra(Constants.PUESTO, trabajador.puesto)
                intent.putExtra(Constants.ANTIGUEDAD, trabajador.antiguedad)
                intent.putExtra(Constants.NUEVO_USER, Constants.NO)
                startActivity(intent)
            }

        })


    }
}
