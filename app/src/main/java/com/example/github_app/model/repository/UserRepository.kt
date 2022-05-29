package com.example.github_app.model.repository

interface  UserRepository {
    suspend fun getUser(userName: String):User
}