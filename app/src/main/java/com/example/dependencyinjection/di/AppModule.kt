package com.example.dependencyinjection.di

import com.example.dependencyinjection.model.UserResponse
import com.example.dependencyinjection.network.RetroService
import com.example.dependencyinjection.network.RetrofitInstance
import com.example.dependencyinjection.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    //Provides a singleton instance of the retroService api across the application
    @Provides
    @Singleton
    fun getRetrofitInstance() : RetroService = RetrofitInstance.retrofitInstance()

    //Provides a singleton instance of the repository across the application
    @Provides
    @Singleton
    fun provideRepository(api: RetroService) : UserRepository = UserRepository(api)

}