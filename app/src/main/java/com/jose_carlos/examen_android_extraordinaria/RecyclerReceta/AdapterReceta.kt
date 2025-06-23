package com.jose_carlos.examen_android_extraordinaria.RecyclerReceta

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jose_carlos.examen_android_extraordinaria.Retrofit.DatosReceta
import com.jose_carlos.examen_android_extraordinaria.R
import com.jose_carlos.examen_android_extraordinaria.Retrofit.RecetaResponse
import okhttp3.Response

class AdapterReceta (
    var recipeList: List<DatosReceta> = emptyList(),
    private val onItemSelected: (String) -> Unit, // Aquí le pasamos la función lambda.
) :
    RecyclerView.Adapter<RecetaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecetaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RecetaViewHolder(layoutInflater.inflate(R.layout.item_receta, parent, false))
    }

    override fun onBindViewHolder(holder: RecetaViewHolder, position: Int) {
        val item = recipeList[position]
        holder.bind(item, onItemSelected) // Le pasamos aquí la lambda para cada uno de los VHolder.
    }

    // Devolvemos la extensión de la lista
    override fun getItemCount() = recipeList.size

    // Creamos una funcion para updatear la lista que recibimos.
    @SuppressLint("NotifyDataSetChanged")
    fun updateList(recipeList: List<DatosReceta>) {
        this.recipeList = recipeList
        notifyDataSetChanged()
    }
}