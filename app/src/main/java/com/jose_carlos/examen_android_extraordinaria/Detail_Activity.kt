package com.jose_carlos.examen_android_extraordinaria

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.jose_carlos.examen_android_extraordinaria.Retrofit.APIservice
import com.jose_carlos.examen_android_extraordinaria.Retrofit.RetrofitClient
import com.jose_carlos.examen_android_extraordinaria.databinding.ActivityDetailBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Detail_Activity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    // Instanciamos retrofit:
    val api = RetrofitClient.instance.create(APIservice::class.java)


    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Creamos el extra del intent:
        val id: String = intent.getStringExtra(EXTRA_ID).orEmpty()
        getProductInformation(id)

    }

    private fun getProductInformation(id: String) {

        lifecycleScope.launch(Dispatchers.IO) {
            val response = api.searchById(id)
            withContext(Dispatchers.Main) {

                // Picasso.get().load(superheroItemResponse.image.imageUrl).into(binding.cardImage)
                Picasso.get().load(response.body()?.image).into(binding.ivRecipe)
                binding.cookingtime.text = response.body()?.cookTimeMinutes.toString()
                binding.prepTime.text = response.body()?.prepTimeMinutes.toString()
                binding.mealtipe.text = response.body()?.mealType.toString()
                binding.rating.text = response.body()?.rating.toString()
                binding.servings.text = response.body()?.servings.toString()
                // mealTipe rating, servings
            }
        }

    }
}