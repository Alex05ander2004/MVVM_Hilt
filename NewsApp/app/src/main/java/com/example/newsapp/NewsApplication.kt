package com.example.newsapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// @HiltAndroidApp genera el componente de inyección raíz
// Hilt necesita esta clase para inicializar el grafo de dependencias
@HiltAndroidApp
class NewsApplication : Application()