package com.sergiolopez.rickandmortywithgraphql.framework.di

import com.sergiolopez.rickandmortywithgraphql.data.datasources.LocalDataSource
import com.sergiolopez.rickandmortywithgraphql.data.datasources.RemoteDataSource
import com.sergiolopez.rickandmortywithgraphql.framework.data.database.RoomDataSource
import com.sergiolopez.rickandmortywithgraphql.framework.data.server.ServerUniverseCharacterDataSource
import com.sergiolopez.rickandmortywithgraphql.framework.data.server.UniverseCharacterRemoteServer
import com.sergiolopez.rickandmortywithgraphql.framework.data.server.UniverseUniverseCharacterRemoteClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FrameworkModule {

    @Provides
    @Singleton
    @Named("baseUrl")
    fun baseUrlProvider(): String = "https://rickandmortyapi.com/graphql"

    @Provides
    fun universeCharacterRemoteServerProvider(
        @Named("baseUrl") baseUrl: String
    ): UniverseCharacterRemoteServer =
        UniverseUniverseCharacterRemoteClient(baseUrl)

    @Provides
    fun localDataSourceProvider(): LocalDataSource = RoomDataSource()

    @Provides
    fun remoteDataSourceProvider(universeCharacterRemoteServer: UniverseCharacterRemoteServer): RemoteDataSource =
        ServerUniverseCharacterDataSource(universeCharacterRemoteServer)
}