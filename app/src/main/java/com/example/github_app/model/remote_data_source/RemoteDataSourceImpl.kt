package com.example.github_app.model.remote_data_source

import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiClient: ApiClient,
) : RemoteDataSource{
    override suspend fun getGithubUser(userName: String): GithubUser {
        val response = apiClient.getGithubUser(userName = userName)
        if (response.isSuccessful) {
            return requireNotNull(response.body())
        }
        throw HttpException()
    }
}

class HttpException: Throwable()