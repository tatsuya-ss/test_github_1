package com.example.test_github_1

import com.example.test_github_1.github.data.Repo
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import com.example.test_github_1.github.data.Result

// https://api.github.com/users/tatsuya-ss/repos
interface GitHubService {
    @GET("users/{user}/repos")
    suspend fun listRepos(
        @Path("user") user: String
    ): List<Repo>
}

interface GitHubRemoteDataSource {
    suspend fun listRepos(user: String): Result<List<Repo>>
}

class GitHubRemoteDataSourceImpl : GitHubRemoteDataSource {
    override suspend fun listRepos(user: String): Result<List<Repo>> {
        val retrofit = makeRetrofit()
        val gitHubService = retrofit.create(GitHubService::class.java)
        return try {
            val result = gitHubService.listRepos(user)
            Result.Success(result)
        } catch (error: java.lang.Exception) {
            Result.Failure(error)
        }
    }

    private fun makeRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
    }
}
