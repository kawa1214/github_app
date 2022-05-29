package com.example.github_app.model.repository

import com.example.github_app.model.remote_data_source.GithubUser
import com.example.github_app.model.remote_data_source.RemoteDataSource
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
) : UserRepository {
    override suspend fun getUser(userName: String): User {
        return remoteDataSource.getGithubUser(userName = userName).toUser()
    }
}

private fun GithubUser.toUser(): User {
    return User(
        userId = UserId(value = id),
        name = name,
        avatarImage = NetworkImage(url = Url(value = avatarUrl)),
        blogUrl = Url(value = blog)
    )
}