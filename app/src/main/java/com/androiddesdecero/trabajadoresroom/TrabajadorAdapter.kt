package com.androiddesdecero.trabajadoresroom

import android.app.Activity
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androiddesdecero.trabajadoresroom.data.Trabajador
import kotlinx.android.synthetic.main.list_item_trabajador.view.*
import java.io.File
import javax.xml.transform.Templates

/**
 * Created by albertopalomarrobledo on 14/3/18.
 */
class TrabajadorAdapter(val trabajadores: List<Trabajador>, val activity: Activity): RecyclerView.Adapter<TrabajadorAdapter.TrabajadorViewHolder>() {
    override fun getItemCount(): Int {
        return trabajadores.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrabajadorViewHolder {
        var layoutInflate = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_trabajador, parent, false)
        return TrabajadorViewHolder(layoutInflate)
    }

    override fun onBindViewHolder(holder: TrabajadorViewHolder, position: Int) {
        val trabajador = trabajadores[position]
        holder.bindTrabajador(trabajador, activity)
    }


    class TrabajadorViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindTrabajador(trabajador: Trabajador, activity: Activity){
            itemView.setOnClickListener({

                val intent = Intent(itemView.context, InsertEditActivity::class.java)
                intent.putExtra(Constants.ID, trabajador.id)
                intent.putExtra(Constants.NOMBRE, trabajador.name)
                intent.putExtra(Constants.PUESTO, trabajador.puesto)
                intent.putExtra(Constants.ANTIGUEDAD, trabajador.antiguedad)
                intent.putExtra(Constants.NUEVO_USER, Constants.NO)
                itemView.context.startActivity(intent)
                activity.finish()
            })
            itemView.litNombre.text = trabajador.name
            itemView.litPuesto.text = trabajador.puesto
            itemView.litAntiguedad.text = trabajador.antiguedad
        }
    }
}