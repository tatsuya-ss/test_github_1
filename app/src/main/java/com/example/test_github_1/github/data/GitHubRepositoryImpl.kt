package com.example.test_github_1.github.data

import com.example.test_github_1.GitHubRemoteDataSource
import com.example.test_github_1.GitHubRemoteDataSourceImpl
import com.example.test_github_1.github.domain.GitHubRepository

class GitHubRepositoryImpl(
    private val gitHubRemoteDataSource: GitHubRemoteDataSource = GitHubRemoteDataSourceImpl(),
) : GitHubRepository {
    override suspend fun listRepos(user: String): Result<List<Repo>> {
        return gitHubRemoteDataSource.listRepos(user)
    }
}