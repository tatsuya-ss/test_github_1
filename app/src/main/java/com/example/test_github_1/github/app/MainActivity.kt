package com.example.test_github_1.github.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.test_github_1.R

class MainActivity : AppCompatActivity() {

    private val viewModel: GitHubViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observeLiveData()
        viewModel.onCreate()
    }

    private fun observeLiveData() {
        viewModel.repos.observe(this) {
            Log.d("tatsuyaDebug", "observeLiveData: ${it}")
        }
    }
}