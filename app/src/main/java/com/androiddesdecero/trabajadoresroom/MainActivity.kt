package com.androiddesdecero.trabajadoresroom

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
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

    }
}
