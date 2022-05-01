package com.example.test_github_1.github.domain

import com.example.test_github_1.github.data.Repo
import com.example.test_github_1.github.data.GitHubRepositoryImpl
import com.example.test_github_1.github.data.Result


class GitHubUseCase(
    private val gitHubRepository: GitHubRepository = GitHubRepositoryImpl(),
) {
    suspend fun listRepos(user: String): Result<List<Repo>> {
        return gitHubRepository.listRepos(user)
    }
}