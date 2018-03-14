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

        }

        ieaSalvar.setOnClickListener({
            var trabajadorSalvar = Trabajador(0,
                    ieaNombre.text.toString(),
                    ieaPuesto.text.toString(),
                    ieaAntiguedad.text.toString())

            if (nuevoTrabajador.equals(Constants.SI)){
                TrabajadorDB.getDatabase(applicationContext).trabajadorDAO().insertTrabajador(trabajadorSalvar)
                finish()
            }else{

            }
        })

    }
}
