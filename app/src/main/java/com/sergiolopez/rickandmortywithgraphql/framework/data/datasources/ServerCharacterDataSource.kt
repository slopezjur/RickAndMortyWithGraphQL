package com.sergiolopez.rickandmortywithgraphql.framework.data.datasources

import com.apollographql.apollo.api.Response
import com.sergiolopez.rickandmortywithgraphql.CharacterListQuery
import com.sergiolopez.rickandmortywithgraphql.data.datasources.RemoteDataSource

class ServerCharacterDataSource(
    private val characterRemoteServer: CharacterRemoteServer
) : RemoteDataSource {

    override suspend fun getCharacters(): Response<CharacterListQuery.Data> {
        return characterRemoteServer.listCharacters()
    }
}