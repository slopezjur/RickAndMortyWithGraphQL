package com.sergiolopez.rickandmortywithgraphql.framework

import com.sergiolopez.rickandmortywithgraphql.data.datasources.RemoteDataSource
import com.sergiolopez.rickandmortywithgraphql.framework.data.datasources.CharacterRemoteClient
import com.sergiolopez.rickandmortywithgraphql.framework.data.datasources.CharacterRemoteServer
import com.sergiolopez.rickandmortywithgraphql.framework.data.datasources.ServerCharacterDataSource
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
    fun characterRemoteServerProvider(
        @Named("baseUrl") baseUrl: String
    ): CharacterRemoteServer =
        CharacterRemoteClient(baseUrl)

    @Provides
    fun remoteDataSourceProvider(characterRemoteServer: CharacterRemoteServer): RemoteDataSource =
        ServerCharacterDataSource(characterRemoteServer)
}