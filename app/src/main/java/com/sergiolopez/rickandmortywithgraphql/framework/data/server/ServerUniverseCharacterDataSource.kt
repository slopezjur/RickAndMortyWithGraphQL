package com.sergiolopez.rickandmortywithgraphql.framework.data.server

import com.apollographql.apollo.api.Response
import com.sergiolopez.rickandmortywithgraphql.UniverseCharacterListQuery
import com.sergiolopez.rickandmortywithgraphql.data.datasources.RemoteDataSource

class ServerUniverseCharacterDataSource(
    private val universeCharacterRemoteServer: UniverseCharacterRemoteServer
) : RemoteDataSource {

    override suspend fun getUniverseCharacters(): Response<UniverseCharacterListQuery.Data> {
        return universeCharacterRemoteServer.listUniverseCharacters()
    }
}