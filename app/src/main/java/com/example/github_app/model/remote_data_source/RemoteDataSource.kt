package com.example.github_app.model.remote_data_source

interface RemoteDataSource {
    suspend fun getGithubUser(userName: String): GithubUser
}