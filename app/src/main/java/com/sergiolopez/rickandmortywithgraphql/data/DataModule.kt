package com.sergiolopez.rickandmortywithgraphql.data

import com.sergiolopez.rickandmortywithgraphql.data.datasources.LocalDataSource
import com.sergiolopez.rickandmortywithgraphql.data.datasources.RemoteDataSource
import com.sergiolopez.rickandmortywithgraphql.data.repositories.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun characterRepositoryProvider(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ) = CharacterRepository(localDataSource, remoteDataSource)
}