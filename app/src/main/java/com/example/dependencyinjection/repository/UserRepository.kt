package com.example.dependencyinjection.repository

import com.example.dependencyinjection.model.UserResponse
import com.example.dependencyinjection.network.RetroService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(private val userApi: RetroService) {

    fun getPost() : Call<UserResponse> {
        return userApi.getPost()
    }

}