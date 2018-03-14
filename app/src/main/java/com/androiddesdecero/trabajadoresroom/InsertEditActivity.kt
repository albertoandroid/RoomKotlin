package com.androiddesdecero.trabajadoresroom

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.androiddesdecero.trabajadoresroom.data.Trabajador
import com.androiddesdecero.trabajadoresroom.data.TrabajadorDB
import kotlinx.android.synthetic.main.activity_insert_edit.*

class InsertEditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_edit)

        var nuevoTrabajador = intent.getStringExtra(Constants.NUEVO_USER)
        var trabajador = Trabajador(0, "","", "")

        if(nuevoTrabajador.equals(Constants.SI)){

        }else{
            trabajador.id = intent.getIntExtra(Constants.ID, 0)
            trabajador.name = intent.getStringExtra(Constants.NOMBRE)
            ieaNombre.setText(trabajador.name)
            trabajador.puesto = intent.getStringExtra(Constants.PUESTO)
            ieaPuesto.setText(trabajador.puesto)
            trabajador.antiguedad = intent.getStringExtra(Constants.ANTIGUEDAD)
            ieaAntiguedad.setText(trabajador.antiguedad)
        }

        ieaBorrar.setOnClickListener({
            if(nuevoTrabajador.equals(Constants.SI)){

            }else{
                TrabajadorDB.getDatabase(applicationContext).trabajadorDAO().deleteWorker(trabajador)
                finish()
            }
        })

        ieaSalvar.setOnClickListener({
            var trabajadorSalvar = Trabajador(0,
                    ieaNombre.text.toString(),
                    ieaPuesto.text.toString(),
                    ieaAntiguedad.text.toString())

            if (nuevoTrabajador.equals(Constants.SI)){
                TrabajadorDB.getDatabase(applicationContext).trabajadorDAO().insertTrabajador(trabajadorSalvar)
                finish()
            }else{
                trabajadorSalvar.id = trabajador.id
                TrabajadorDB.getDatabase(applicationContext).trabajadorDAO().updateWorker(trabajadorSalvar)
                finish()
            }
        })

    }
}
