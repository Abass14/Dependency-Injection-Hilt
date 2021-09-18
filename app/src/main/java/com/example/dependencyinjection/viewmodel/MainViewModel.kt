package com.example.dependencyinjection.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dependencyinjection.model.UserResponse
import com.example.dependencyinjection.network.RetrofitInstance
import com.example.dependencyinjection.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject
import javax.security.auth.callback.Callback

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() { //The repository is injected here in the viewmodel

    private val _getUserLiveData: MutableLiveData<UserResponse?> = MutableLiveData()
    val getUserLiveData: LiveData<UserResponse?> = _getUserLiveData

    fun getUser(){
        val call = repository.getPost()

        call.enqueue(object : retrofit2.Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful){
                    _getUserLiveData.postValue(response.body())
                }else{
                    _getUserLiveData.postValue(null)
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                _getUserLiveData.postValue(null)
            }

        })
    }

}