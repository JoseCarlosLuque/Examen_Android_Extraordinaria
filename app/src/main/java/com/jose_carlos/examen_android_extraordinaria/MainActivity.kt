package com.jose_carlos.examen_android_extraordinaria

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.jose_carlos.examen_android_extraordinaria.Detail_Activity.Companion.EXTRA_ID
import com.jose_carlos.examen_android_extraordinaria.RecyclerReceta.AdapterReceta
import com.jose_carlos.examen_android_extraordinaria.Retrofit.APIservice
import com.jose_carlos.examen_android_extraordinaria.Retrofit.RecetaResponse
import com.jose_carlos.examen_android_extraordinaria.Retrofit.RetrofitClient
import com.jose_carlos.examen_android_extraordinaria.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val api = RetrofitClient.instance.create(APIservice::class.java)
    private lateinit var adapter: AdapterReceta

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

     fun initUI() {
        lifecycleScope.launch(Dispatchers.IO) {
            val myResponse: Response<RecetaResponse> = api.getAllRecipes()

            // Nevesitamos hacer esto para que se cambie en el hilo principal.
            withContext(Dispatchers.Main) {
                adapter.updateList(myResponse.body()?.recipes ?: emptyList())
            }

            adapter = AdapterReceta{ navigateToDetail(it) }
            binding.MiRecycler.setHasFixedSize(true)
            binding.MiRecycler.layoutManager = LinearLayoutManager(this@MainActivity)
            binding.MiRecycler.adapter = adapter
        }


    }

    private fun navigateToDetail(id: String) {
        val intent = Intent(this, Detail_Activity::class.java)
        intent.putExtra( EXTRA_ID, id)
        startActivity(intent) // Lanzamos la activity.
    }
}
/*
    Para subirlo al repo del examen:
    git remote add origin https://github.com/JoseCarlosLuque/Examen_Android_Extraordinaria.git
git push -u origin main

 */