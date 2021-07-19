package com.sergiolopez.rickandmortywithgraphql.framework

import com.sergiolopez.rickandmortywithgraphql.data.datasources.RemoteDataSource
import com.sergiolopez.rickandmortywithgraphql.framework.data.datasources.ServerCharacterDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class FrameworkModule {

    @Provides
    fun remoteDataSourceProvider(): RemoteDataSource {
        return ServerCharacterDataSource()
    }
}