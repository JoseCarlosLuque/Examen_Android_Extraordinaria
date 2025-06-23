package com.jose_carlos.examen_android_extraordinaria.Retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface APIservice {

    @GET("recipes")
    suspend fun getAllRecipes (): Response<RecetaResponse>
    // Tener en cuenta que se ha de usar el Response de Retrofit, no el de OKhttp3

    // Endpoint para buscar por el id del superheroe:
    @GET("recipes/{recipes-id}")
    suspend fun searchById (@Path("recipes-id") recipeId: String): Response<DatosReceta>
}