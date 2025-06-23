package com.jose_carlos.examen_android_extraordinaria.RecyclerReceta

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.jose_carlos.examen_android_extraordinaria.Retrofit.DatosReceta
import com.jose_carlos.examen_android_extraordinaria.databinding.ItemRecetaBinding
import com.squareup.picasso.Picasso

class RecetaViewHolder(view: View ) : RecyclerView.ViewHolder(view) {

    // Binding de la receta:
    private val binding = ItemRecetaBinding.bind(view)

    fun bind(datos: DatosReceta, onItemSelected: (String) -> Unit) {
        binding.recipeName.text = datos.name
        Picasso.get().load(datos.image).into(binding.cardImage)
        binding.root.setOnClickListener{
            onItemSelected(datos.id.toString())
            /*
            *   Le pasamos el id del superhero e a la funcion.
            */
        }
    }
}