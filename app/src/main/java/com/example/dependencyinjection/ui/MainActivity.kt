package com.example.dependencyinjection.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.dependencyinjection.R
import com.example.dependencyinjection.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //Get an instance of the viewModel using viewmodels()
    private val viewModel: MainViewModel by viewModels()

    private lateinit var text : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text = findViewById(R.id.text)

        observeResponse()

    }


    //Observe the response of the live data
    private fun observeResponse(){
        viewModel.getUserLiveData.observe(this, Observer {
            if (it != null){
                text.text = it.toString()
                Log.d("Call", "This $it")
            }
        })
        viewModel.getUser()
    }
}