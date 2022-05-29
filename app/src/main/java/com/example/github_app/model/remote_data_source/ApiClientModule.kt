package com.example.github_app.model.remote_data_source

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ApiClientModule {

    /**
     * [ApiClient]のDIに用いられるインスタンスを生成して返す
     */
    @ExperimentalSerializationApi
    @Provides
    @Singleton
    fun provideApiClient(apiClientProvider: ApiClientProvider): ApiClient {
        return apiClientProvider.provide()
    }
}