package com.example.test_github_1.github.domain

import com.example.test_github_1.github.data.Repo
import com.example.test_github_1.github.data.Result

interface GitHubRepository {
    suspend fun listRepos(user: String): Result<List<Repo>>
}
