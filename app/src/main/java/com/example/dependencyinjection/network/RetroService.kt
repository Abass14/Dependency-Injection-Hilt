package com.example.dependencyinjection.network

import com.example.dependencyinjection.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface RetroService {

    @GET("users")
    fun getPost() : Call<UserResponse>

}