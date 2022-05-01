package com.example.test_github_1.github.app

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_github_1.github.data.Repo
import com.example.test_github_1.github.data.Result
import com.example.test_github_1.github.domain.GitHubUseCase
import kotlinx.coroutines.launch

class GitHubViewModel(
    private val gitHubUseCase: GitHubUseCase = GitHubUseCase(),
) : ViewModel() {

    val repos: MutableLiveData<List<Repo>> = MutableLiveData()

    fun onCreate() {
        viewModelScope.launch {
            val result = gitHubUseCase.listRepos("tatsuya-ss")
            when (result) {
                is Result.Success -> {
                    Log.d("tatsuyaDebug", "${result.result}")
                }
                is Result.Failure -> {
                    Log.d("tatsuyaDebug", "${result}")
                }
            }
        }
    }
}