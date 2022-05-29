package com.example.github_app.model.repository

data class User(
    val userId: UserId,
    val name: String,
    val avatarImage: NetworkImage,
    val blogUrl: Url,
)