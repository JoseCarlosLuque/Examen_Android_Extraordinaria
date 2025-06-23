package com.jose_carlos.examen_android_extraordinaria

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

    }
}

/*
    Para subirlo al repo del examen:
    git remote add origin https://github.com/JoseCarlosLuque/Examen_Android_Extraordinaria.git
git push -u origin main

 */