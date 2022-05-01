package com.example.test_github_1.github.data


sealed class Result<out R> {
    data class Success<out T>(val result: T) : Result<T>()
    data class Failure(val exception: Exception) : Result<Nothing>()
}
