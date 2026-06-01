package com.example.newsapp.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

// El módulo queda vacío porque NewsRepository
// se inyecta solo con @Singleton + @Inject constructor()
@Module
@InstallIn(SingletonComponent::class)
object AppModule